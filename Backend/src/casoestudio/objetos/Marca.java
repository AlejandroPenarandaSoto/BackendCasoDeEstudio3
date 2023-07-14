package casoestudio.objetos;

public class Marca extends MarcaModelo{
    private String marca;

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
