package casoestudio.producto_Concreto;


import casoestudio.api.ApiConector;
import casoestudio.objetos.Proforma;
import casoestudio.producto_abstracto._Usuario;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class _UsuarioDAO extends ApiConector {

    public void registrarUsuario(_Usuario usr){
        try{
            String mConecc= this.getAPIURL("INSERT INTO FgE_Usuarios (nombre,apellido1,apellido2,telefono,id_rol, usuario, contrasenia)" +
                    " VALUES (\""+usr.getNombre()+"\" , \""+usr.getApellido1()+"\",\""+usr.getApellido2()+"\",\""+usr.getTelefono()+"\",\""+usr.getRol_id()+"\",\""+usr.getUsuario()+"\",\""+usr.getPswd()+"\");");
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
                int statusCode = response.statusCode();
                usuarioId  = parseUIdFromResponse(jsonResponse);
                HttpHeaders headers = response.headers();

                System.out.println("Status code: " + statusCode);
                System.out.println("Response headers: " + headers);
                System.out.println("Response body: " + jsonResponse);

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

    private String parseUsernameFromResponse(String jsonResponse) {
        String userName = " ";
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("usuario")) {
                            userName = marcaObject.get("usuario").getAsString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }
    private String parsePswdFromResponse(String jsonResponse) {
        String Pswd = " ";
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("contrasenia")) {
                            Pswd = marcaObject.get("contrasenia").getAsString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Pswd;
    }
    public List<String> getVendedores() {
        List<String> usuarios= new ArrayList<>();
        try {
            String query = "SELECT nombre FROM FgE_Usuarios WHERE id_rol = 2";
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

    public List<Proforma> getProformasByUsuarioId(int idUsuario) {
        List<Proforma> proformas = new ArrayList<>();
        try {

            String query = "SELECT id_proforma, id_Cliente,id_Vendedor,estado FROM FgE_Proformas WHERE id_Vendedor = " + idUsuario;


            String encodedUrl = this.getAPIURL(query);


            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                proformas.addAll(parseProformasFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return proformas;
    }
    public List<Proforma> getProformasCliente(int idUsuario) {
        List<Proforma> proformas = new ArrayList<>();
        try {

            String query = "SELECT id_proforma, id_Cliente,id_Vendedor,estado FROM FgE_Proformas WHERE id_Cliente = " + idUsuario;


            String encodedUrl = this.getAPIURL(query);


            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                proformas.addAll(parseProformasFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return proformas;
    }

    private List<Proforma> parseProformasFromResponse(String jsonResponse) {
        List<Proforma> parsedProformas = new ArrayList<>();

        try {
            JsonElement jsonElement = JsonParser.parseString(jsonResponse);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            boolean success = jsonObject.get("success").getAsBoolean();
            if (success) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    for (JsonElement element : resultArray) {
                        JsonObject proformaObject = element.getAsJsonObject();
                        String estado = proformaObject.get("estado").getAsString();
                        int idCliente = proformaObject.get("id_Cliente").getAsInt();
                        int idProforma = proformaObject.get("id_proforma").getAsInt();
                        int idVendedor=proformaObject.get("id_Vendedor").getAsInt();
                        Proforma proforma = new Proforma(estado, idCliente,idProforma, idVendedor);
                        parsedProformas.add(proforma);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsedProformas;
    }
    private int parseidRolFromResponse(String jsonResponse) {
        int id_rol = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("id_rol")) {
                            id_rol = marcaObject.get("id_rol").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id_rol;
    }

    public int getIdRolByUsername(String usuarioValue) {
        int idRol = 0;
        try {
            String query = "SELECT id_rol FROM FgE_Usuarios WHERE usuario = \"" + usuarioValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                idRol  = parseidRolFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  idRol ;
    }
    public String getUsername(String user) {
        String username = " ";
        try {
            String query = "SELECT usuario FROM FgE_Usuarios WHERE usuario = \"" + user + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                username  = parseUsernameFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } return username;

    }

    public String getPswd(String _pswd) {
        String pswd = " ";
        try {
            String query = "SELECT * FROM FgE_Usuarios WHERE contrasenia = \"" + _pswd + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                pswd  = parsePswdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return pswd;
    }



    public _Usuarios getDataUser(String usr) {
        _Usuarios usuario = new _Usuarios();
        int userID = Integer.parseInt(usr);
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_Usuarios WHERE id_usuario = " + userID);
            HttpResponse<String> resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            if (statusCode == 200) {
                String jsonResponse = resp.body();
                usuario = parseUsuario(jsonResponse);
            } else {
                System.out.println("Error al obtener datos del usuario. Código de estado: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    private _Usuarios parseUsuario(String jsonResponse) {
        _Usuarios user = new _Usuarios();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (resultArray.size() > 0) { // Verificamos si hay resultados en el arreglo
                        JsonObject userModeloJson = resultArray.get(0).getAsJsonObject();
                        int id_rol = userModeloJson.get("id_rol").getAsInt();
                        String nombre = userModeloJson.get("nombre").getAsString();
                        String apellido1 = userModeloJson.get("apellido1").getAsString();
                        String apellido2 = userModeloJson.get("apellido2").getAsString();
                        String telefono = userModeloJson.get("telefono").getAsString();

                        // Actualizamos los valores del objeto _Usuarios con los datos obtenidos
                        user.setRol_id(id_rol);
                        user.setNombre(nombre);
                        user.setApellido1(apellido1);
                        user.setApellido2(apellido2);
                        user.setTelefono(telefono);
                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return user;
    }


    public int getUsuarioId(String usuarioValue) {
        int usuarioId = 0;
        try {
            String query = "SELECT id_usuario FROM FgE_Usuarios WHERE usuario = \"" + usuarioValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                int statusCode = response.statusCode();
                usuarioId  = parseUId(jsonResponse);
                HttpHeaders headers = response.headers();

                System.out.println("Status code: " + statusCode);
                System.out.println("Response headers: " + headers);
                System.out.println("Response body: " + jsonResponse);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  usuarioId ;
    }
    private int parseUId(String jsonResponse) {
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