package casoestudio.objetos;




import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class RepuestoDAO extends ApiConector {



    public void registrarRepuesto(Repuesto rp){
        try{

            String mConecc= this.getAPIURL("INSERT INTO FgE_Repuestos(id_TipoRepuesto,nombre,descripcion,categoria,precio,id_MarcaRespuesto) " + "VALUES ( " + rp.getTipoR() + " , '" + rp.getNombre() + "','" + rp.getDescripcion() + "', '" + rp.getCategoria()+ "', " + rp.getPrecio()+ ", " + rp.getMarcaR() + ")");
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
    public List<Repuesto> getRepuesto() {
        List<Repuesto> RepuestosList = new ArrayList<>();
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_Repuestos");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();
            String jsonResponse = (String) resp.body();
            System.out.println("JSON response: " + jsonResponse);
            RepuestosList = parseRepuestoFromResponse(jsonResponse);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return RepuestosList;
    }

    private List<Repuesto> parseRepuestoFromResponse(String jsonResponse) {
        List<Repuesto> RepuestoList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject repuestoJson = element.getAsJsonObject();
                    int tipoR = repuestoJson.get("id_TipoRepuesto").getAsInt();
                    String nombre = repuestoJson.get("nombre").getAsString();
                    String descripcion = repuestoJson.get("descripcion").getAsString();
                    String categoria = repuestoJson.get("categoria").getAsString();
                    double precio = repuestoJson.get("precio").getAsDouble();
                    int marcaR = repuestoJson.get("id_MarcaRespuesto").getAsInt();
                    Repuesto repuesto = new Repuesto(tipoR, nombre, descripcion, categoria, precio, marcaR);
                    RepuestoList.add(repuesto);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return RepuestoList;
    }




}
