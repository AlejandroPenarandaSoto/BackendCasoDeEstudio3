package casoestudio.objetos;

public class MarcaRepuesto extends Repuesto{

    private String Marca;

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public MarcaRepuesto(String nombre, String descripcion, int codID, String categoria, String modelo, int precio, String annio, String marca) {
        super(nombre, descripcion, codID, categoria, modelo, precio, annio);
        Marca = marca;
    }

    @Override
    public String toString() {
        return "MarcaRepuesto{" +
                "Marca='" + Marca + '\'' +
                '}';
    }
}
