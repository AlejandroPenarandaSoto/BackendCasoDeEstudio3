package casoestudio.objetos;

public class Rechazo {

    private int id_Rechazo;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_Rechazo() {
        return id_Rechazo;
    }

    public void setId_Rechazo(int id_Rechazo) {
        this.id_Rechazo = id_Rechazo;
    }

    public Rechazo(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rechazo(int id_Rechazo, String descripcion) {
        this.id_Rechazo = id_Rechazo;
        this.descripcion = descripcion;
    }

    public Rechazo() {
    }

    @Override
    public String toString() {
        return "Rechazo{" +
                "id_Rechazo=" + id_Rechazo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
