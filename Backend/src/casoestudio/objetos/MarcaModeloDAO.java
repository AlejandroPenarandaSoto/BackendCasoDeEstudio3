package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaModeloDAO extends ApiConector {
    public void registrarAnio(MarcaModelo mc) {
        try {
            String mConecc = this.getAPIURL("INSERT INTO FgE_MarcaModelo (annno, id_Marca, id_Modelo) VALUES (" + mc.getAnio() + ", " + mc.getMarcaId() + ", " + mc.getModeloId() + ")");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();

            String jsonResponse = (String) resp.body();

            System.out.println("Status code: " + statusCode);
            System.out.println("Response headers: " + headers);
            System.out.println("Response body: " + jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<MarcaModelo> getMarcaModeloData() {
        List<MarcaModelo> marcaModeloList = new ArrayList<>();
        try {
            //select MM.id_Marca, MM.id_MarcaModelo,MM.id_Modelo,MM.annno,ma.Marca,MO.Modelo from fge_marcamodelo MM inner join fge_marca ma on ma.idMarca = MM.id_Marca inner join fge_modelo MO on MO.idModelo = MM.id_Modelo
            String mConecc = this.getAPIURL("SELECT * FROM FgE_MarcaModelo");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();

            String jsonResponse = (String) resp.body();

            System.out.println("Status code: " + statusCode);
            System.out.println("Response headers: " + headers);
            System.out.println("Response body: " + jsonResponse);

            // Parse the JSON response and populate the marcaModeloList
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
}

