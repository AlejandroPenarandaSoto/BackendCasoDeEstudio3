package casoestudio.producto_Concreto;

import casoestudio.objetos.Proforma;
import casoestudio.producto_abstracto._Usuario;

public class _Usuarios implements _Usuario {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private int rol_id;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }
    @Override
    public void actualizarProforma(Proforma proforma) {
        if (getRol_id() == 1) { // Cambiar 1 por el ID correspondiente al vendedor
            System.out.println("Usuario " + getNombre() + " recibió una nueva proforma: " + proforma);
            System.out.println("Mensaje recibido correctamente.");
            // Aquí puedes realizar cualquier acción adicional que requieras cuando se reciba una nueva proforma.
        }
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public _Usuarios(String nombre, String apellido1, String apellido2, String telefono, int rol_id) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.rol_id = rol_id;
    }

    public _Usuarios(String nombre, String apellido1, String apellido2, String telefono) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
    }

    public _Usuarios() {
    }


    //Funciones de Interfaz
    @Override
    public String get_info_usuario() {
        return "Datos del usario: " + getNombre() +" "+ getApellido1() + " " + getApellido2() + " \nNumero de telefono: " + getTelefono() +" \nRol ID "+ getRol_id() +" \nRol: "+ getRol()  ;
    }

    @Override
    public int generarRolID() {
        return (int) (Math.random() *2 + 1);
    }

    @Override
    public String getRol() {

        String rol=" ";
        if(getRol_id() == 1){
            rol = "Vendedor";
        } else if (getRol_id()==2) {
            rol = "Cliente";
        }

        return "El rol del usuario es: " + rol;

    }

    @Override
    public String toString() {
        return "_Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol_id=" + rol_id +
                '}';
    }
}
