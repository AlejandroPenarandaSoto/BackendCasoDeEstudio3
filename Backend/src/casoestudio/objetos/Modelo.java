package casoestudio.objetos;

public class Modelo {
    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Modelo(String modelo) {
        this.modelo = modelo;
    }

    public Modelo() {
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "modelo='" + modelo + '\'' +
                '}';
    }
}
