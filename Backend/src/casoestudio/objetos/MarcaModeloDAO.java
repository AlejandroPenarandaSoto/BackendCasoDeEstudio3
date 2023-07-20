package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MarcaModeloDAO extends ApiConector {
    public void registrarAnio(MarcaModelo mc) {
        try {
            String mConecc = this.getAPIURL("INSERT INTO FgE_MarcaModelo (annno, id_Marca, id_Modelo) VALUES (" + mc.getAnio() + ", " + mc.getMarcaId() + ", " + mc.getModeloId() + ")");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<MarcaModelo> getMarcaModeloData() {
        List<MarcaModelo> marcaModeloList = new ArrayList<>();
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_MarcaModelo");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            marcaModeloList = parseMarcaModeloFromResponse(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return marcaModeloList;
    }
    private List<MarcaModelo> parseMarcaModeloFromResponse(String jsonResponse) {
        List<MarcaModelo> marcaModeloList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject marcaModeloJson = element.getAsJsonObject();
                    int idMarcaModelo = marcaModeloJson.get("id_MarcaModelo").getAsInt();
                    int idMarca = marcaModeloJson.get("id_Marca").getAsInt();
                    int idModelo = marcaModeloJson.get("id_Modelo").getAsInt();
                    int anno = marcaModeloJson.get("annno").getAsInt();
                    MarcaModelo marcaModelo = new MarcaModelo(idMarcaModelo, anno, idMarca, idModelo);
                    marcaModeloList.add(marcaModelo);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return marcaModeloList;
    }
    public List<String> getMMs() {
        List<String> mms = new ArrayList<>();
        try {
            String query = "SELECT ma.Marca, MO.Modelo " +
                    "FROM FgE_MarcaModelo MM " +
                    "INNER JOIN FgE_Marca ma ON ma.idMarca = MM.id_Marca " +
                    "INNER JOIN FgE_Modelo MO ON MO.idModelo = MM.id_Modelo;";

            String encodedUrl = this.getAPIURL(query);

            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                mms.addAll(parseMMsFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return mms;
    }

    private List<String> parseMMsFromResponse(String jsonResponse) {
        List<String> mms = new ArrayList<>();
        Map<String, String> concatenatedMap = new LinkedHashMap<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");

                for (JsonElement element : resultArray) {
                    JsonObject mmJson = element.getAsJsonObject();
                    String marca = mmJson.get("Marca").getAsString();
                    String modelo = mmJson.get("Modelo").getAsString();
                    String concatenatedName = marca + " - " + modelo;
                    concatenatedMap.put(concatenatedName, marca + "-" + modelo);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        mms.addAll(concatenatedMap.keySet());
        return mms;
    }
    public int queryIdMarcaModelo(String selectedBrand, String selectedModel) {
        int idMarcaModelo = -1;
        try {
            String encodedBrand = URLEncoder.encode(selectedBrand, StandardCharsets.UTF_8.toString());
            String encodedModel = URLEncoder.encode(selectedModel, StandardCharsets.UTF_8.toString());
            String query = "SELECT MM.id_MarcaModelo " +
                    "FROM FgE_MarcaModelo MM " +
                    "INNER JOIN FgE_Marca ma ON ma.idMarca = MM.id_Marca " +
                    "INNER JOIN FgE_Modelo MO ON MO.idModelo = MM.id_Modelo " +
                    "WHERE ma.Marca = '" + encodedBrand + "' AND MO.Modelo = '" + encodedModel + "';";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                idMarcaModelo = parseIdMarcaModeloFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return idMarcaModelo;
    }
    private int parseIdMarcaModeloFromResponse(String jsonResponse) {
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                if (resultArray.size() > 0) {
                    JsonObject mmJson = resultArray.get(0).getAsJsonObject();
                    return mmJson.get("id_MarcaModelo").getAsInt();
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

