package casoestudio.objetos;

import casoestudio.api.ApiConector;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class TipoRepuestoDAO extends ApiConector {

    public void registrarTipoRepuesto(TipoRepuesto tr){
        try{

            String mConecc= this.getAPIURL("INSERT INTO FgE_TipoRepuesto(Tipo) VALUES (\""+tr.getTipo()+"\");");
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

    public List<TipoRepuesto> getTipoRepuesto() {
        List<TipoRepuesto> tipoRepuestosList = new ArrayList<>();
        try {

            String mConecc = this.getAPIURL("SELECT * FROM FgE_TipoRepuesto");
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
        return tipoRepuestosList;
    }





}
