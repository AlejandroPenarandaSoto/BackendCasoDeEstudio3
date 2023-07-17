package casoestudio.objetos;

public class Modelo{
    private String modelo;
    private int id_modelo;

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Modelo(String modelo, int id_modelo) {
        this.modelo = modelo;
        this.id_modelo = id_modelo;
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
