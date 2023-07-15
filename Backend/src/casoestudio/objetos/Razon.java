package casoestudio.objetos;

public class Razon {

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Razon(String descripcion) {
        this.descripcion = descripcion;
    }

    public Razon() {
    }

    @Override
    public String toString() {
        return "Razon{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
