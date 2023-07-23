package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.*;

import static java.lang.System.out;

public class TipoRepuestoDAO extends ApiConector {

    public void registrarTipoRepuesto(TipoRepuesto tr){
        try{

            String mConecc= this.getAPIURL("INSERT INTO FgE_TipoRepuesto(Tipo) VALUES (\""+tr.getTipo()+"\");");
            HttpResponse resp =this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();

            String jsonResponse = (String) resp.body();

            //Elminar
            out.println("Status code: " + statusCode);
            out.println("Response headers: " + headers);
            out.println("Response body: " + jsonResponse);
        }catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public List<String> getTipoRepuesto() {
        List<String> tipoRepuestosList = new ArrayList<>();
        try {
            String query = "SELECT Tipo FROM FgE_TipoRepuesto";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            int statusCode = response.statusCode();
            HttpHeaders headers = response.headers();

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                tipoRepuestosList.addAll(parseTipoR(jsonResponse));

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return tipoRepuestosList;
    }

    private List<String> parseTipoR(String jsonResponse) {
        List<String> tipoList = new ArrayList<>();
        Map<String, String> concatenatedMap = new LinkedHashMap();

        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                Iterator var6 = resultArray.iterator();
                while(var6.hasNext()) {
                    JsonElement element = (JsonElement)var6.next();
                    JsonObject tipoJ = element.getAsJsonObject();
                    String Tipo = tipoJ.get("Tipo").getAsString();
                    String concatenatedName = Tipo ;
                    concatenatedMap.put(concatenatedName, Tipo );
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }  tipoList.addAll(concatenatedMap.keySet());

        return tipoList;
    }

    public int getTipoRepuestoId(String tipoR) {
        int trId = 0;
        try {
            String query = "SELECT idTipoRepuesto FROM FgE_TipoRepuesto WHERE Tipo = \"" + tipoR + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                int statusCode = response.statusCode();
                trId  = parsetrId(jsonResponse);
                HttpHeaders headers = response.headers();

                System.out.println("Status code: " + statusCode);
                System.out.println("Response headers: " + headers);
                System.out.println("Response body: " + jsonResponse);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  trId ;
    }
    private int parsetrId(String jsonResponse) {
        int trId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("idTipoRepuesto")) {
                            trId = marcaObject.get("idTipoRepuesto").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trId;
    }


}
