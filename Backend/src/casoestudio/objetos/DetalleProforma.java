package casoestudio.objetos;

import java.util.ArrayList;

public class DetalleProforma {

    private int  id_Proforma;
    private int id_Repuesto;
    private String estado;
    private int id_Rechazo;

    public DetalleProforma() {
    }

    public DetalleProforma(int id_Proforma, int id_Repuesto, String estado, int id_Rechazo) {
        this.id_Proforma = id_Proforma;
        this.id_Repuesto = id_Repuesto;
        this.estado = estado;
        this.id_Rechazo = id_Rechazo;
    }

    public int getId_Proforma() {
        return id_Proforma;
    }

    public void setId_Proforma(int id_Proforma) {
        this.id_Proforma = id_Proforma;
    }

    public int getId_Repuesto() {
        return id_Repuesto;
    }

    public void setId_Repuesto(int id_Repuesto) {
        this.id_Repuesto = id_Repuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_Rechazo() {
        return id_Rechazo;
    }

    public void setId_Rechazo(int id_Rechazo) {
        this.id_Rechazo = id_Rechazo;
    }

    @Override
    public String toString() {
        return "DetalleProforma{" +
                "id_Proforma=" + id_Proforma +
                ", id_Repuesto=" + id_Repuesto +
                ", estado='" + estado + '\'' +
                ", id_Rechazo=" + id_Rechazo +
                '}';
    }
}
