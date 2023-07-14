package casoestudio.objetos;

public class Nave {
    private String categoria;
    private String marca;
    private String modelo;
    private int anio;
    private int codigo;
    private String color;
    private String  motor;
    private String propulsores;

    public Nave(String categoria, String marca, String modelo, int anio, int codigo, String color, String motor, String propulsores) {
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.codigo = codigo;
        this.color = color;
        this.motor = motor;
        this.propulsores = propulsores;
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

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPropulsores() {
        return propulsores;
    }

    public void setPropulsores(String propulsores) {
        this.propulsores = propulsores;
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
                ", motor='" + motor + '\'' +
                ", propulsores='" + propulsores + '\'' +
                '}';
    }
}
