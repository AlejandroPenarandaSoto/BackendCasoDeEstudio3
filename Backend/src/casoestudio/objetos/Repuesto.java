package casoestudio.objetos;

import java.util.ArrayList;

public class Repuesto {
    private String Nombre;
    private String Descripcion;
   // private int codID;
    private String Categoria;
  //  private String Modelo;
    private double Precio;
    private int Annio;
    private int cantidad;
    private int marcaR;
    private int tipoR;

    public Repuesto( int tipoR,String nombre, String descripcion,  String categoria,  double precio,int marcaR, int annio, int cantidad) {
        Nombre = nombre;
        Descripcion = descripcion;
      //  this.codID = codID;
        Categoria = categoria;
     //   Modelo = modelo;
        Precio = precio;
        Annio = annio;
        this.cantidad = cantidad;
        this.marcaR = marcaR;
        this.tipoR = tipoR;
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



    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }



    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }


    public int getMarcaR() {
        return marcaR;
    }

    public void setMarcaR(int marcaR) {
        this.marcaR = marcaR;
    }

    public int getTipoR() {
        return tipoR;
    }

    public void setTipoR(int tipoR) {
        this.tipoR = tipoR;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getAnnio() {
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
                ", Categoria='" + Categoria + '\'' +
                ", Precio=" + Precio +
                ", Annio=" + Annio +
                ", cantidad=" + cantidad +
                ", marcaR=" + marcaR +
                ", tipoR=" + tipoR +
                '}';
    }
}
