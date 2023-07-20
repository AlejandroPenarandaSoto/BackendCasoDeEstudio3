package casoestudio.objetos;

public class Proforma {

    private String estado;
    private int id_Cliente;
    private int id_Proforma;
    private int id_Vendedor;

    public Proforma(String estado, int id_Cliente, int id_Vendedor) {
        this.estado = estado;
        this.id_Cliente = id_Cliente;
        this.id_Vendedor = id_Vendedor;
    }

    public Proforma(String estado, int id_Cliente, int id_Proforma, int id_Vendedor) {
        this.estado = estado;
        this.id_Cliente = id_Cliente;
        this.id_Proforma = id_Proforma;
        this.id_Vendedor = id_Vendedor;
    }

    public int getId_Proforma() {
        return id_Proforma;
    }

    public void setId_Proforma(int id_Proforma) {
        this.id_Proforma = id_Proforma;
    }

    public Proforma() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Vendedor() {
        return id_Vendedor;
    }

    public void setId_Vendedor(int id_Vendedor) {
        this.id_Vendedor = id_Vendedor;
    }

    @Override
    public String toString() {
        return "Proforma{" +
                "estado='" + estado + '\'' +
                ", id_Cliente=" + id_Cliente +
                ", id_Vendedor=" + id_Vendedor +
                '}';
    }
}