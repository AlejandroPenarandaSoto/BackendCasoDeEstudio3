package casoestudio.objetos;


import casoestudio.api.ApiConector;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class MarcaRepuestoDAO extends ApiConector {





    public void registrarMarcaRepuesto(MarcaRepuesto mr){
        try{

            String mConecc= this.getAPIURL("INSERT INTO FgE_MarcaRespuesto(Marca) VALUES (\""+mr.getMarca()+"\");");
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

    public List<MarcaRepuesto> getMarcaRepuesto() {
        List<MarcaRepuesto> marcaRepuestosList = new ArrayList<>();
        try {

            String mConecc = this.getAPIURL("SELECT * FROM FgE_MarcaRespuesto");
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
        return marcaRepuestosList;
    }





}
