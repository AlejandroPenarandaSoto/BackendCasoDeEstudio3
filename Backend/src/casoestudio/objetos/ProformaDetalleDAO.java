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
            String mConecc = this.getAPIURL("INSERT INTO FgE_DetalleProforma (id_detalle, id_proforma, id_repuesto,id_razonRechazo ,estado ) " +
                    "VALUES ('" + d.getId_Proforma() + "', '" + d.getId_Repuesto() + "', '" + d.getId_Rechazo() + "', '" + d.getEstado() + "');");
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

    public List<DetalleProforma> getDetallesProf() {
        List<DetalleProforma> Detalles = new ArrayList<>();
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_DetalleProforma");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            Detalles = parseDetallesProforma(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Detalles;
    }

    private List<DetalleProforma> parseDetallesProforma(String jsonResponse) {
        List<DetalleProforma> DetallesProformaList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject detalleJson = element.getAsJsonObject();
                    if (detalleJson.get("id_proforma") == null || detalleJson.get("id_repuesto") == null ||
                            detalleJson.get("estado") == null || detalleJson.get("id_razonRechazo") == null) {
                        // Si algún campo es nulo, omitimos este detalle y continuamos con el siguiente
                        continue;
                    }
                    int id_Proforma = detalleJson.get("id_proforma").getAsInt();
                    int id_Repuesto = detalleJson.get("id_repuesto").getAsInt();
                    String estado = detalleJson.get("estado").getAsString();
                    int id_Rechazo = detalleJson.get("id_razonRechazo").getAsInt();

                    DetalleProforma detalles = new DetalleProforma(id_Proforma,id_Repuesto,estado,id_Rechazo);

                    DetallesProformaList.add(detalles);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return DetallesProformaList;
    }
    public List<Rechazo> ObtenerRazonesdeRechazo(){
        RechazoDAO rechazoDAO = new RechazoDAO();
        return rechazoDAO.getRazonesRechazo();
    }
    public  List<Repuesto> getRepuesto(){
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        return repuestoDAO.getRepuesto();
    }
}

