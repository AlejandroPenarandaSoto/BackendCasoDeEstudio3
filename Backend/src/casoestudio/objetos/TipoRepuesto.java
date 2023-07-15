package casoestudio.objetos;

public class TipoRepuesto{

    private String Tipo;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public TipoRepuesto(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoRepuesto{" +
                "Tipo='" + Tipo + '\'' +
                '}';
    }
}
