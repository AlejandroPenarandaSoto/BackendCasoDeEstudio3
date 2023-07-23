package casoestudio.producto_Concreto;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.Gestores.Gestor;
import casoestudio.objetos.NaveDAO;
import casoestudio.producto_Concreto.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Scanner;

public class mainPrueba {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;


    private static Scanner scanner;
    private static Gestor appGestor = new Gestor();

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        NaveDAO  naveDAO = new NaveDAO();
        _UsuarioDAO usuarioDAO = new _UsuarioDAO();

       // appGestor.registrarRepuesto(1,"prueba4","prueba4","prueba4",3000,1,2023,2);
        appGestor.tipoRepuestoID("Mecanico");


    }
    public static void print(String pText) {

        print(pText, true);
    }

    public static void print(String pText, Boolean pLinea) {
        if (pLinea)
            System.out.println(pText);
        else
            System.out.print(pText);
    }




}
