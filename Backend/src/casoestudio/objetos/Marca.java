package casoestudio.objetos;

public class Marca{
    private String marca;
    private int id_marca;

    public Marca(String marca, int id_marca) {
        this.marca = marca;
        this.id_marca = id_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Marca(String marca) {
        this.marca = marca;
    }

    public Marca() {
    }

    @Override
    public String toString() {
        return "Marca{" +
                "marca='" + marca + '\'' +
                '}';
    }
}
