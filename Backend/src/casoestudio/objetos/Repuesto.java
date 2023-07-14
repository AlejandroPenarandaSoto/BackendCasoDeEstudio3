package casoestudio.objetos;

import java.util.ArrayList;

public class Repuesto {
    private String Nombre;
    private String Descripcion;
    private int codID;
    private String Categoria;
    private String Modelo;
    private int Precio;
    private int Annio;
    private int cantidad;

    public Repuesto(String nombre, String descripcion, int codID, String categoria, String modelo, int precio, int annio, int cantidad) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.codID = codID;
        Categoria = categoria;
        Modelo = modelo;
        Precio = precio;
        Annio = annio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getCodID() {
        return codID;
    }

    public void setCodID(int codID) {
        this.codID = codID;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public Integer getAnnio() {
        return Annio;
    }

    public void setAnnio(int annio) {
        Annio = annio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                "Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", codID=" + codID +
                ", Categoria='" + Categoria + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Precio=" + Precio +
                ", Annio=" + Annio +
                ", cantidad=" + cantidad +
                '}';
    }
}
