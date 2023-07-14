package casoestudio.objetos;

public class Nave {
    private String categoria;
    private String marca;
    private String modelo;
    private int anio;
    private int codigo;
    private String color;
    private boolean escudo;
    private boolean hipervelocidad;

    public Nave(String categoria, String marca, String modelo, int anio, int codigo, String color, boolean escudo, boolean hipervelocidad) {
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.codigo = codigo;
        this.color = color;
        this.escudo = escudo;
        this.hipervelocidad = hipervelocidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscudo() {
        return escudo;
    }

    public void setEscudo(boolean escudo) {
        this.escudo = escudo;
    }

    public boolean isHipervelocidad() {
        return hipervelocidad;
    }

    public void setHipervelocidad(boolean hipervelocidad) {
        this.hipervelocidad = hipervelocidad;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "categoria='" + categoria + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", codigo=" + codigo +
                ", color='" + color + '\'' +
                ", escudo=" + escudo +
                ", hipervelocidad=" + hipervelocidad +
                '}';
    }
}
