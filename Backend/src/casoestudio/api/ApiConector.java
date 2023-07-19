package casoestudio.api;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiConector {
    String baseUrl = "http://eeds.club/BISOFT-12/";
    String usr = "G01";
    String pwd = "BISOFT_FgE_G01";
    public String getAPIURL(String pQuery){
        return baseUrl +
                "?usuario=" + URLEncoder.encode(usr, StandardCharsets.UTF_8) +
                "&clave=" + URLEncoder.encode(pwd, StandardCharsets.UTF_8) +
                "&query=" + URLEncoder.encode(pQuery, StandardCharsets.UTF_8);
    }
    public HttpResponse EjecutarLlamado(String encodedUrl) throws IOException,InterruptedException{
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(encodedUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
}
