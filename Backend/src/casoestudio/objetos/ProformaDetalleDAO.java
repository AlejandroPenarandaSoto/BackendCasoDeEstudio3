package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ProformaDetalleDAO extends ApiConector {
    public void insertarDetalleProforma(DetalleProforma d) {
        try {
            String mConecc = this.getAPIURL("INSERT INTO FgE_DetalleProforma (id_proforma, id_repuesto,id_razonRechazo ,estado ) " +
                    "VALUES ( '" + d.getId_proforma() + "', '" + d.getId_repuesto() + "', '" + d.getId_rechazo()+ "', '" +d.getEstado()   + "');");
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

    public List<DetalleProforma> getDetallesProf() {
        List<DetalleProforma> DetallesList = new ArrayList<>();
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_DetalleProforma");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            DetallesList = parseDetallesProforma(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return DetallesList;
    }

    private List<DetalleProforma> parseDetallesProforma(String jsonResponse) {
        List<DetalleProforma> DetallesProformaList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject detalleJson = element.getAsJsonObject();

                    int id_proforma = detalleJson.get("id_proforma").isJsonNull() ? 0 : detalleJson.get("id_proforma").getAsInt();
                    int id_repuesto = detalleJson.get("id_repuesto").isJsonNull() ? 0 : detalleJson.get("id_repuesto").getAsInt();
                    String estado = detalleJson.get("estado").isJsonNull() ? "" : detalleJson.get("estado").getAsString();
                    int id_rechazo = detalleJson.get("id_razonRechazo").isJsonNull() ? 0 : detalleJson.get("id_razonRechazo").getAsInt();
                    DetalleProforma detalles = new DetalleProforma(id_proforma, id_repuesto, estado, id_rechazo);
                    DetallesProformaList.add(detalles);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return DetallesProformaList;
    }



}

