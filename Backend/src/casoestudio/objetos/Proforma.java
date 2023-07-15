package casoestudio.objetos;

import casoestudio.producto_Concreto._Usuarios;

import java.util.ArrayList;

public class Proforma {
    private ArrayList<Repuesto> lineasProformas;
    private String codigo;
    private String estado;
    private ArrayList<Razon> lineasRazones;
    private ArrayList<_Usuarios> listaUsuarios;

    public Proforma(ArrayList<Repuesto> lineasProformas, String codigo, String estado, ArrayList<Razon> lineasRazones, ArrayList<_Usuarios> listaUsuarios) {
        this.lineasProformas = lineasProformas;
        this.codigo = codigo;
        this.estado = estado;
        this.lineasRazones = lineasRazones;
        this.listaUsuarios = listaUsuarios;
    }

    public Proforma() {
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

    public ArrayList<Razon> getLineasRazones() {
        return lineasRazones;
    }

    public void setLineasRazones(ArrayList<Razon> lineasRazones) {
        this.lineasRazones = lineasRazones;
    }

    public ArrayList<_Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<_Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return "Proforma{" +
                "lineasProformas=" + lineasProformas +
                ", codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                ", lineasRazones=" + lineasRazones +
                ", listaUsuarios=" + listaUsuarios +
                '}';
    }
}
