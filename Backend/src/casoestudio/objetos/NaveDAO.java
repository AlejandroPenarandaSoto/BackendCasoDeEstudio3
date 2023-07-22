package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class NaveDAO extends ApiConector {
    public void registrarNave(Nave nav) {
        try {
            String mConecc = this.getAPIURL("INSERT INTO FgE_Naves (codigo_identificacion,color,id_categoria,id_MarcaModelo,id_usuario) " +
                    "VALUES ('" + nav.getCodigo() + "', '" + nav.getColor() + "', " + nav.getIdCat() + ", " + nav.getMarcaM() + ", " + nav.getIdU() + ")");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Nave> getNaveData() {
        List<Nave> NaveList = new ArrayList<>();
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_Naves");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            NaveList = parseNaveFromResponse(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return NaveList;
    }

    private List<Nave> parseNaveFromResponse(String jsonResponse) {
        List<Nave> NaveList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject naveModeloJson = element.getAsJsonObject();
                    String codigo = naveModeloJson.get("codigo_identificacion").getAsString();
                    String color = naveModeloJson.get("color").getAsString();
                    int idMarcaModelo = naveModeloJson.get("id_MarcaModelo").getAsInt();
                    int idU = naveModeloJson.get("id_usuario").getAsInt();
                    int idCat = naveModeloJson.get("id_Categoria").getAsInt();
                    Nave nave = new Nave(codigo, color, idCat, idMarcaModelo, idU);
                    NaveList.add(nave);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return NaveList;
    }

//lp

    public Nave getNaveDataUser(String nav) {
        Nave nave = new Nave();
        int NavID = Integer.parseInt(nav);
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_Naves where id_nave = "+ NavID );
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            nave = parseNave(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return nave;
    }



    private Nave parseNave(String jsonResponse) {
        Nave nave = new Nave();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (resultArray.size() > 0) { // Verificamos si hay resultados en el arreglo
                        JsonObject naveModeloJson = resultArray.get(0).getAsJsonObject();
                        String codigo = naveModeloJson.get("codigo_identificacion").getAsString();
                        String color = naveModeloJson.get("color").getAsString();
                        int idCategoria = naveModeloJson.get("id_Categoria").getAsInt();
                        int idMarcaModelo = naveModeloJson.get("id_MarcaModelo").getAsInt();
                        int idUsuario = naveModeloJson.get("id_usuario").getAsInt();

                        // Actualizamos los valores de la instancia de Nave con los datos obtenidos
                        nave.setCodigo(codigo);
                        nave.setColor(color);
                        nave.setIdCat(idCategoria);
                        nave.setMarcaM(idMarcaModelo);
                        nave.setIdU(idUsuario);
                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return nave;
    }





}
