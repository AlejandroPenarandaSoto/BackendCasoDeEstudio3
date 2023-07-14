package casoestudio.objetos;

import java.util.ArrayList;

public class Cliente {
    private int Telefono;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private ArrayList<Nave> Naves;

    public Cliente(int telefono, String nombre, String apellido1, String apellido2, ArrayList<Nave> naves) {
        Telefono = telefono;
        Nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        Naves = naves;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public ArrayList<Nave> getNaves() {
        return Naves;
    }

    public void setNaves(ArrayList<Nave> naves) {
        Naves = naves;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Telefono=" + Telefono +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido1='" + Apellido1 + '\'' +
                ", Apellido2='" + Apellido2 + '\'' +
                ", Naves=" + Naves +
                '}';
    }
}

