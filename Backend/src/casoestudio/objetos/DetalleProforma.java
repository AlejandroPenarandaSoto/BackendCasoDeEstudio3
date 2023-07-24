package casoestudio.objetos;

import java.util.ArrayList;

public class DetalleProforma {

    private int  id_proforma;
    private int id_repuesto;
    private String estado;
    private int id_rechazo;


    public DetalleProforma() {
    }

    public DetalleProforma(int id_proforma, int id_repuesto, String estado, int id_rechazo) {
        this.id_proforma = id_proforma;
        this.id_repuesto = id_repuesto;
        this.estado = estado;
        this.id_rechazo = id_rechazo;

    }

    public int getId_proforma() {
        return id_proforma;
    }

    public void setId_proforma(int id_proforma) {
        this.id_proforma = id_proforma;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_rechazo() {
        return id_rechazo;
    }

    public void setId_rechazo(int id_rechazo) {
        this.id_rechazo = id_rechazo;
    }



    @Override
    public String toString() {
        return "DetalleProforma{" +
                "id_proforma=" + id_proforma +
                ", id_repuesto=" + id_repuesto +
                ", estado='" + estado + '\'' +
                ", id_rechazo=" + id_rechazo +

                '}';
    }
}
