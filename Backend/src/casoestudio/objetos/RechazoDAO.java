package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RechazoDAO extends ApiConector {

    public void insertarRazonRechazo(Rechazo r) {
        try {
            String mConecc = this.getAPIURL("INSERT INTO FgE_RazonesRechazo (descripcion) VALUES ('" + r.getDescripcion() + "');");
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

    public List<Rechazo> getRazonesRechazo() {
        List<Rechazo> RazonesRechazoList = new ArrayList<>();
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_RazonesRechazo");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            System.out.println("JSON response: " + jsonResponse);
            RazonesRechazoList = parseRazonesRechazo(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return RazonesRechazoList;
    }

    private List<Rechazo> parseRazonesRechazo(String jsonResponse) {
        List<Rechazo> RazonesRechazoList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject rechazoJson = element.getAsJsonObject();
                    int id_Rechazo = rechazoJson.get("id_razon").getAsInt();
                    String descripcion = rechazoJson.get("descripcion").getAsString();
                    Rechazo rechazo = new Rechazo(id_Rechazo, descripcion);
                    RazonesRechazoList.add(rechazo);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return RazonesRechazoList;
    }
}