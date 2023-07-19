package casoestudio.objetos;

import casoestudio.api.ApiConector;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.*;

public class CategoriaDAO extends ApiConector {


    public void registrarCategoria(Categoria cat){
        try{
            String mConecc= this.getAPIURL("INSERT INTO FgE_Categoria (Categoria) VALUES (\""+cat.getCategoria()+"\");");
            HttpResponse resp =this.EjecutarLlamado(mConecc);
            int statusCode = resp.statusCode();
            HttpHeaders headers = resp.headers();

            String jsonResponse = (String) resp.body();

            System.out.println("Status code: " + statusCode);
            System.out.println("Response headers: " + headers);
            System.out.println("Response body: " + jsonResponse);
        }catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
