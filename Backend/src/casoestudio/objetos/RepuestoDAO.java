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

            String mConecc= this.getAPIURL("INSERT INTO FgE_Repuestos(id_TipoRepuesto,nombre,descripcion,categoria,precio,id_MarcaRespuesto) " +
                    "VALUES ( " + rp.getTipoR() + " , '" + rp.getNombre() + "','" + rp.getDescripcion() + "', '" + rp.getCategoria()+ "', " + rp.getPrecio()+ ", " + rp.getMarcaR() + ")");

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
                    int precio = repuestoJson.get("precio").getAsInt();
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


    public List<Repuesto> getRepuesto() {
        List<Repuesto> RepuestosList = new ArrayList<>();
        try {

            String mConecc = this.getAPIURL("SELECT * FROM FgE_Repuestos");
            HttpResponse resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();

            String jsonResponse = (String) resp.body();

            System.out.println("Status code: " + statusCode);
            System.out.println("Response headers: " + headers);
            System.out.println("Response body: " + jsonResponse);



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return RepuestosList;
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

}
