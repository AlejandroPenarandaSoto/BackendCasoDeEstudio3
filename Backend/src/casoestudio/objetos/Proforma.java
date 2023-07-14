package casoestudio.objetos;

import java.util.ArrayList;

public class Proforma {
    private ArrayList<Repuesto> lineasProformas;
    private Vendedor vendedor;
    private String codigo;
    private String estado;

    public Proforma(ArrayList<Repuesto> lineasProformas, Vendedor vendedor, String codigo, String estado) {
        this.lineasProformas = lineasProformas;
        this.vendedor = vendedor;
        this.codigo = codigo;
        this.estado = estado;
    }

    public ArrayList<Repuesto> getLineasProformas() {
        return lineasProformas;
    }

    public void setLineasProformas(ArrayList<Repuesto> lineasProformas) {
        this.lineasProformas = lineasProformas;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
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
                ", vendedor=" + vendedor +
                ", codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
