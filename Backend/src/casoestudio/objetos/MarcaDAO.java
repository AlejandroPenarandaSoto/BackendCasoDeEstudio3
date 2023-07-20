package casoestudio.objetos;
import casoestudio.api.ApiConector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MarcaDAO extends ApiConector {
    public List<String> getMarcas() {
        List<String> marcas = new ArrayList<>();
        try {
            String query = "SELECT Marca FROM FgE_Marca";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                marcas.addAll(parseMarcasFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return marcas;
    }
    private List<String> parseMarcasFromResponse(String jsonResponse) {
        List<String> marcas = new ArrayList<>();
        try {

            JsonElement jsonElement = JsonParser.parseString(jsonResponse);
            JsonObject jsonObject = jsonElement.getAsJsonObject();


            boolean success = jsonObject.get("success").getAsBoolean();
            if (success) {

                JsonObject dataObject = jsonObject.getAsJsonObject("data");


                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");


                    for (JsonElement element : resultArray) {
                        JsonObject marcaObject = element.getAsJsonObject();
                        String marcaValue = marcaObject.get("Marca").getAsString();
                        marcas.add(marcaValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marcas;
    }
    public void registrarMarca(Marca mar){
        try{
            String mConecc= this.getAPIURL("INSERT INTO FgE_Marca (Marca) VALUES (\""+mar.getMarca()+"\");");
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
    public int getMarcaId(String marcaValue) {
        int marcaId = 0;
        try {
            String query = "SELECT idMarca FROM FgE_Marca WHERE Marca = \"" + marcaValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                marcaId = parseMarcaIdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return marcaId;
    }



    private int parseMarcaIdFromResponse(String jsonResponse) {
        int marcaId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("idMarca")) {
                            marcaId = marcaObject.get("idMarca").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marcaId;
    }


}
