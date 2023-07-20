package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloDAO extends ApiConector {
    public List<String> getModelos() {
        List<String> modelos = new ArrayList<>();
        try {
            String query = "SELECT Modelo FROM FgE_Modelo";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                modelos.addAll(parseModelosFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return modelos;
    }

    private List<String> parseModelosFromResponse(String jsonResponse) {
        List<String> modelos = new ArrayList<>();
        try {

            JsonElement jsonElement = JsonParser.parseString(jsonResponse);
            JsonObject jsonObject = jsonElement.getAsJsonObject();


            boolean success = jsonObject.get("success").getAsBoolean();
            if (success) {

                JsonObject dataObject = jsonObject.getAsJsonObject("data");


                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");


                    for (JsonElement element : resultArray) {
                        JsonObject modeloObject = element.getAsJsonObject();
                        String modeloValue = modeloObject.get("Modelo").getAsString();
                        modelos.add(modeloValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelos;
    }

    public void registrarModelo(Modelo mod){
        try{
            String mConecc= this.getAPIURL("INSERT INTO FgE_Modelo(Modelo) VALUES (\""+mod.getModelo()+"\");");
            HttpResponse resp =this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
        }catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public int getModeloId(String modeloValue) {
        int modeloId = 0;
        try {
            String query = "SELECT idModelo FROM FgE_Modelo WHERE Modelo = \"" + modeloValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                modeloId = parseModeloIdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return modeloId;
    }

    private int parseModeloIdFromResponse(String jsonResponse) {
        int modeloId = 0;
        try {

            JsonElement jsonElement = JsonParser.parseString(jsonResponse);
            JsonObject jsonObject = jsonElement.getAsJsonObject();


            if (jsonObject.has("data") && jsonObject.get("data").isJsonObject()) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");


                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");


                    if (resultArray.size() > 0) {

                        JsonObject modeloObject = resultArray.get(0).getAsJsonObject();


                        modeloId = modeloObject.get("idModelo").getAsInt();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modeloId;
    }

}
