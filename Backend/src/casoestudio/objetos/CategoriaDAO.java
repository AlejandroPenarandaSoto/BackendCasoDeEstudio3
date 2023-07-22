package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO extends ApiConector {
    public List<String> getCategorias() {
        List<String> categorias= new ArrayList<>();
        try {
            String query = "SELECT Categoria FROM FgE_Categoria";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                System.out.println("JSON response: " + jsonResponse);
                categorias.addAll(parseCategoriasFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return categorias;
    }
    private List<String> parseCategoriasFromResponse(String jsonResponse) {
        List<String> categorias = new ArrayList<>();
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
                        String marcaValue = marcaObject.get("Categoria").getAsString();
                        categorias.add(marcaValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }


    public void registrarCategoria(Categoria cat){
        try{
            String mConecc= this.getAPIURL("INSERT INTO FgE_Categoria (Categoria) VALUES (\""+cat.getCategoria()+"\");");
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
    public int getCatId(String catValue) {
        int catId = 0;
        try {
            String query = "SELECT id_Categoria  FROM FgE_Categoria WHERE Categoria = \"" + catValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                catId  = parseCatIdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return  catId ;
    }



    private int parseCatIdFromResponse(String jsonResponse) {
        int catId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject marcaObject = resultArray.get(0).getAsJsonObject();
                        if (marcaObject.has("id_Categoria")) {
                            catId = marcaObject.get("id_Categoria").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catId;
    }

    //lp

    public Categoria getDataCategoria(String ctg) {
        Categoria categoria = new Categoria();
        int ctgID = Integer.parseInt(ctg);
        try {
            String mConecc = this.getAPIURL("SELECT * FROM FgE_Categoria WHERE id_Categoria = " + ctgID);
            HttpResponse<String> resp = this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            if (statusCode == 200) {
                String jsonResponse = resp.body();
                categoria = parseCategoria(jsonResponse);
            } else {
                System.out.println("Error al obtener datos del usuario. Código de estado: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    private Categoria parseCategoria(String jsonResponse) {
        Categoria ctg = new Categoria();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (resultArray.size() > 0) { // Verificamos si hay resultados en el arreglo
                        JsonObject categoriaModeloJson = resultArray.get(0).getAsJsonObject();
                        String categoria = categoriaModeloJson.get("Categoria").getAsString();
                        // Actualizamos los valores del objeto _Usuarios con los datos obtenidos
                        ctg.setCategoria(categoria);

                    }
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return ctg;
    }




}
