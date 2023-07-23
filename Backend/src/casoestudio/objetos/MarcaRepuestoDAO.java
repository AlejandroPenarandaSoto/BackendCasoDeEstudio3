package casoestudio.objetos;


import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.*;


public class MarcaRepuestoDAO extends ApiConector {





    public void registrarMarcaRepuesto(MarcaRepuesto mr){
        try{

            String mConecc= this.getAPIURL("INSERT INTO FgE_MarcaRespuesto(Marca) VALUES (\""+mr.getMarca()+"\");");
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

    public List<String> getMarcaRepuesto() {
        List<String> marcaRepuestosList = new ArrayList<>();
        try {
            String query = "SELECT Marca FROM FgE_MarcaRespuesto";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            int statusCode = response.statusCode();
            HttpHeaders headers = response.headers();

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                marcaRepuestosList.addAll(parseMarcaR(jsonResponse));

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return marcaRepuestosList;
    }
    private List<String> parseMarcaR(String jsonResponse) {
        List<String> marcaRlis = new ArrayList<>();
        Map<String, String> concatenatedMap = new LinkedHashMap();

        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                Iterator var6 = resultArray.iterator();
                while(var6.hasNext()) {
                    JsonElement element = (JsonElement)var6.next();
                    JsonObject marcaJ = element.getAsJsonObject();
                    String marca = marcaJ.get("Marca").getAsString();
                    String concatenatedName = marca ;
                    concatenatedMap.put(concatenatedName, marca );
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }  marcaRlis.addAll(concatenatedMap.keySet());

        return marcaRlis;
    }


    public int getMarcaRepuestoId(String marcaR) {
        int marcarId = 0;
        try {
            String query = "SELECT idMarcaRespuesto FROM FgE_MarcaRespuesto WHERE Marca = \"" + marcaR + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                int statusCode = response.statusCode();
                marcarId  = parseMrId(jsonResponse);
                HttpHeaders headers = response.headers();

                System.out.println("Status code: " + statusCode);
                System.out.println("Response headers: " + headers);
                System.out.println("Response body: " + jsonResponse);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  marcarId ;
    }
    private int parseMrId(String jsonResponse) {
        int MrId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("idMarcaRespuesto")) {
                            MrId = marcaObject.get("idMarcaRespuesto").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MrId;
    }






}
