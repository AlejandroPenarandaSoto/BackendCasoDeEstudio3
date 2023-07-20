package casoestudio.main;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.Fabrica_Concreta.Fabrica_Usuario;
import casoestudio.producto_abstracto._Usuario;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {
    private static Scanner scanner;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        /*scanner= new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Primer Apellido: ");
        String apellido1 = scanner.nextLine();

        System.out.println("Segundo Apellido: ");
        String apellido2 = scanner.nextLine();

        System.out.println("Telefono: ");
        String numTel = scanner.nextLine();

        Usuarios miUser;
        String msj = "";

        miUser = new Fabrica_Usuario();
        msj = CrearFabricaUsuarios(miUser, nombre,apellido1,apellido2,numTel);

        System.out.println(msj);














    }

    public static String CrearFabricaUsuarios(Usuarios uFabrica, String nombre , String apellido1, String apellido2, String numCel){
        _Usuario tmpUser = uFabrica.crearUsuario(nombre,apellido1,apellido2,numCel);
        return tmpUser.get_info_usuario();*/
    }
}