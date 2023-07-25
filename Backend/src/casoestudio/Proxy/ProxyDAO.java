package casoestudio.Proxy;

import casoestudio.api.ApiConector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.http.HttpResponse;

public class ProxyDAO extends ApiConector {

    public int getClienteId(String cotrasenna) {
        int clienteId = 0;
        try {
            String query = "SELECT id_usuario FROM FgE_Usuarios WHERE contrasenia = \"" + cotrasenna + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                clienteId = parseClienteIdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return clienteId;
    }

    private int parseClienteIdFromResponse(String jsonResponse) {
        int clienteId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject clienteObject = resultArray.get(0).getAsJsonObject();
                        if (clienteObject.has("id_usuario")) {
                            clienteId = clienteObject.get("id_usuario").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clienteId;
    }

}
