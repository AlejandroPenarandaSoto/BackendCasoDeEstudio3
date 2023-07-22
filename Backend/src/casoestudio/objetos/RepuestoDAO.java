package casoestudio.objetos;




import casoestudio.api.ApiConector;

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


}
