package casoestudio.objetos;

public class MarcaRepuesto{

    private String Marca;

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public MarcaRepuesto(String marca) {
        Marca = marca;
    }

    @Override
    public String toString() {
        return "MarcaRepuesto{" +
                "Marca='" + Marca + '\'' +
                '}';
    }
}
