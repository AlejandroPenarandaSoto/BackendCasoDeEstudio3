package casoestudio.objetos;

import java.util.ArrayList;

public class Proforma {
    private ArrayList<Repuesto> lineasProformas;
    private String codigo;
    private String estado;

    public Proforma(ArrayList<Repuesto> lineasProformas, String codigo, String estado) {
        this.lineasProformas = lineasProformas;
        this.codigo = codigo;
        this.estado = estado;
    }

    public ArrayList<Repuesto> getLineasProformas() {
        return lineasProformas;
    }

    public void setLineasProformas(ArrayList<Repuesto> lineasProformas) {
        this.lineasProformas = lineasProformas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proforma{" +
                "lineasProformas=" + lineasProformas +
                ", codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
