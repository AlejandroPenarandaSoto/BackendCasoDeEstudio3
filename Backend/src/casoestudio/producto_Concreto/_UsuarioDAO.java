package casoestudio.producto_Concreto;



import casoestudio.api.ApiConector;
import casoestudio.objetos.Categoria;
import casoestudio.objetos.Configuracion;
import casoestudio.producto_abstracto._Usuario;
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

import static java.lang.System.out;

public class _UsuarioDAO extends ApiConector {

    public void registrarUsuario(_Usuario usr){
        try{
            String mConecc= this.getAPIURL("INSERT INTO FgE_Usuarios (nombre,apellido1,apellido2,telefono,id_rol)" +
                    " VALUES (\""+usr.getNombre()+"\" , \""+usr.getApellido1()+"\",\""+usr.getApellido2()+"\",\""+usr.getTelefono()+"\",\""+usr.getRol_id()+"\");");
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
    public void listarUsuarios(){
        try{
            String mConecc= this.getAPIURL("SELECT U.nombre as Nombre, CONCAT(apellido1, ' ', apellido2) as Apellidos, R.nombre_rol as Rol  FROM FgE_Usuarios U " +
                    "INNER JOIN FgE_Roles R on R.id_rol = U.id_rol");
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
    public List<String> getUsuarios() {
        List<String> usuarios= new ArrayList<>();
        try {
            String query = "SELECT nombre FROM FgE_Usuarios WHERE id_rol = 1";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                usuarios.addAll(parseUsuariosFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    private List<String> parseUsuariosFromResponse(String jsonResponse) {
        List<String> usuarios = new ArrayList<>();
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
                        String marcaValue = marcaObject.get("nombre").getAsString();
                        usuarios.add(marcaValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public int getUsuariosId(String usuarioValue) {
        int usuarioId = 0;
        try {
            String query = "SELECT id_usuario FROM FgE_Usuarios WHERE nombre = \"" + usuarioValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                usuarioId  = parseUIdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  usuarioId ;
    }



    private int parseUIdFromResponse(String jsonResponse) {
        int usuarioId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("id_usuario")) {
                            usuarioId = marcaObject.get("id_usuario").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioId;
    }
}