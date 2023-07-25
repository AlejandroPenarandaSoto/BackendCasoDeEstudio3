package casoestudio.producto_Concreto;

import casoestudio.Composite.Componente;
import casoestudio.IObservador.ObservadorProforma;
import casoestudio.objetos.DetalleProforma;
import casoestudio.objetos.Proforma;
import casoestudio.producto_abstracto._Usuario;

import java.util.ArrayList;
import java.util.List;


public class _Usuarios implements _Usuario, Componente, ObservadorProforma {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String usuario;
    private String pswd;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public _Usuarios(String nombre, String apellido1, String apellido2, String telefono, int rol_id,String usuario, String _pswd) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.rol_id = rol_id;
        this.usuario = usuario;
        this.pswd = _pswd;
    }

    public _Usuarios(String nombre, String apellido1, String apellido2, String telefono, int rol_id) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.rol_id = rol_id;
    }

    public _Usuarios(String nombre, String apellido1, String apellido2, String telefono, String usuario, String pswd) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.usuario = usuario;
        this.pswd = pswd;
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
            rol = "Cliente";
        } else if (getRol_id()==2) {
            rol = "Vendedor";
        }

        return "El rol de este usuario es: " +  rol;

    }

    @Override
    public String toString() {
        return "_Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario='" + usuario + '\'' +
                ", pswd='" + pswd + '\'' +
                ", rol_id=" + rol_id +
                '}';
    }

    @Override
    public String getDescripcion() {
        return "Usuario: " + getNombre() + " " + getApellido1() + " " + getApellido2();
    }

    @Override
    public void notificarNuevosDetalles(Proforma prof, DetalleProforma detalleProf) {
        System.out.println("¡Hola, vendedor " + this.nombre + "! Se ha publicado un nuevo detalle de la proforma: " + detalleProf.getId_proforma());
    }
}
