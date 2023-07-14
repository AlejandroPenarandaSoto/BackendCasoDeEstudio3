package casoestudio.objetos;

public class TipoRepuesto extends Repuesto{

    private String Tipo;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public TipoRepuesto(String nombre, String descripcion, int codID, String categoria, String modelo, int precio, String annio, String tipo) {
        super(nombre, descripcion, codID, categoria, modelo, precio, annio);
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoRepuesto{" +
                "Tipo='" + Tipo + '\'' +
                '}';
    }
}
