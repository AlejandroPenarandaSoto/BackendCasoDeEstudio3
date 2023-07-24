package casoestudio.objetos;

import casoestudio.api.ApiConector;
import com.google.gson.*;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProformaDAO extends ApiConector {

    public void insertarProforma(Proforma p) {
        try {
            String mConecc = this.getAPIURL("INSERT INTO FgE_Proformas (estado, id_Cliente, id_Vendedor) VALUES ('" + p.getEstado() + "', '" + p.getId_Cliente() + "', '" + p.getId_Vendedor() + "');");
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

    public List<String> getClientes() {
        List<String> clientes = new ArrayList<>();
        try {
            String query = "SELECT nombre FROM FgE_Usuarios WHERE id_rol = 1";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                System.out.println("JSON response: " + jsonResponse);
                clientes.addAll(parseClientesFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public List<Proforma> getProformas() {
        List<Proforma> proformas = new ArrayList<>();
        try {
            String query = "SELECT * FROM FgE_Proformas ";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                System.out.println("JSON response: " + jsonResponse);
                proformas.addAll(parseProforma(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return proformas;
    }
    private List<Proforma> parseProforma(String jsonResponse) {
        List<Proforma> ProformaList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject proformaJson = element.getAsJsonObject();
                    int id_Vendedor = proformaJson.get("id_Vendedor").isJsonNull() ? 0 : proformaJson.get("id_Vendedor").getAsInt();
                    int id_proforma = proformaJson.get("id_proforma").isJsonNull() ? 0 : proformaJson.get("id_proforma").getAsInt();
                    int id_Cliente = proformaJson.get("id_Cliente").isJsonNull() ? 0 : proformaJson.get("id_Cliente").getAsInt();
                    String estado = proformaJson.get("estado").isJsonNull() ? "" : proformaJson.get("estado").getAsString();

                    Proforma proformas = new Proforma(estado,id_Cliente, id_proforma,id_Vendedor );
                    ProformaList.add(proformas);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return ProformaList;
    }


    private List<String> parseClientesFromResponse(String jsonResponse) {
        List<String> clientes = new ArrayList<>();
        try {

            JsonElement jsonElement = JsonParser.parseString(jsonResponse);
            JsonObject jsonObject = jsonElement.getAsJsonObject();


            boolean success = jsonObject.get("success").getAsBoolean();
            if (success) {

                JsonObject dataObject = jsonObject.getAsJsonObject("data");


                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");


                    for (JsonElement element : resultArray) {
                        JsonObject clienteObject = element.getAsJsonObject();
                        String clienteValue = clienteObject.get("nombre").getAsString();
                        clientes.add(clienteValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public List<String> getVendedores() {
        List<String> vendedores = new ArrayList<>();
        try {
            String query = "SELECT nombre FROM FgE_Usuarios WHERE id_rol = 2";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                System.out.println("JSON response: " + jsonResponse);
                vendedores.addAll(parseVendedoresFromResponse(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    private List<String> parseVendedoresFromResponse(String jsonResponse) {
        List<String> vendedores = new ArrayList<>();
        try {

            JsonElement jsonElement = JsonParser.parseString(jsonResponse);
            JsonObject jsonObject = jsonElement.getAsJsonObject();


            boolean success = jsonObject.get("success").getAsBoolean();
            if (success) {

                JsonObject dataObject = jsonObject.getAsJsonObject("data");


                if (dataObject.has("result") && dataObject.get("result").isJsonArray()) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");


                    for (JsonElement element : resultArray) {
                        JsonObject vendedorObject = element.getAsJsonObject();
                        String vendedorValue = vendedorObject.get("nombre").getAsString();
                        vendedores.add(vendedorValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    public int getClienteId(String clienteValue) {
        System.out.println("Cliente Value: " + clienteValue);
        int clienteId = 0;
        try {
            String query = "SELECT id_usuario FROM FgE_Usuarios WHERE nombre = \"" + clienteValue + "\"";
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

    public int getVendedorId(String vendedorValue) {
        System.out.println("Vendedor Value: " + vendedorValue);
        int vendedorId = 0;
        try {
            String query = "SELECT id_usuario FROM FgE_Usuarios WHERE nombre = \"" + vendedorValue + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                vendedorId = parseVendedorIdFromResponse(jsonResponse);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return vendedorId;
    }

    private int parseVendedorIdFromResponse(String jsonResponse) {
        int vendedorId = 0;
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            if (jsonObject.has("data")) {
                JsonObject dataObject = jsonObject.getAsJsonObject("data");
                if (dataObject.has("result")) {
                    JsonArray resultArray = dataObject.getAsJsonArray("result");
                    if (!resultArray.isJsonNull() && resultArray.size() > 0) {
                        JsonObject vendedorObject = resultArray.get(0).getAsJsonObject();
                        if (vendedorObject.has("id_usuario")) {
                            vendedorId = vendedorObject.get("id_usuario").getAsInt();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedorId;
    }

    public List<Proforma> getProformasByIdCliente(int idCliente) {
        List<Proforma> proformas = new ArrayList<>();
        try {
            String query = "SELECT id_proforma, id_Cliente, id_Vendedor FROM FgE_Proformas WHERE id_Cliente = \"" + idCliente + "\"";
            String encodedUrl = this.getAPIURL(query);
            HttpResponse<String> response = this.EjecutarLlamado(encodedUrl);
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                System.out.println("JSON response: " + jsonResponse);
                proformas.addAll(parseProformaSinEstado(jsonResponse));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return proformas;
    }
    private List<Proforma> parseProformaSinEstado(String jsonResponse) {
        List<Proforma> ProformaSinEstadoList = new ArrayList<>();
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.get("success").getAsBoolean()) {
                JsonArray resultArray = jsonObject.getAsJsonObject("data").getAsJsonArray("result");
                for (JsonElement element : resultArray) {
                    JsonObject proformaJson = element.getAsJsonObject();
                    int id_Proforma = proformaJson.get("id_proforma").getAsInt();
                    int id_Cliente = proformaJson.get("id_Cliente").getAsInt();
                    int id_Vendedor = proformaJson.get("id_Vendedor").getAsInt();

                    Proforma proformas = new Proforma(id_Cliente, id_Proforma,id_Vendedor);
                    ProformaSinEstadoList.add(proformas);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return ProformaSinEstadoList;
    }

}
