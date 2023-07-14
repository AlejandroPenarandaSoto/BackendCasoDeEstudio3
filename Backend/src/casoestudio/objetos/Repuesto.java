package casoestudio.objetos;

import java.util.ArrayList;

public class Repuesto {
    private String Nombre;
    private String Descripcion;
    private int codID;
    private String Categoria;
    private String Modelo;
    private int Precio;
    private String Annio;

    public Repuesto(String nombre, String descripcion, int codID, String categoria, String modelo, int precio, String annio) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.codID = codID;
        Categoria = categoria;
        Modelo = modelo;
        Precio = precio;
        Annio = annio;
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

    public String getAnnio() {
        return Annio;
    }

    public void setAnnio(String annio) {
        Annio = annio;
    }

    @Override
    public String toString() {
        return "Repuesto{" +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", codID=" + codID +
                ", Categoria='" + Categoria + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Precio=" + Precio +
                ", Annio='" + Annio + '\'' +
                '}';
    }
}
