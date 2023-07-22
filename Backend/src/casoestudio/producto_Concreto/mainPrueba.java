package casoestudio.producto_Concreto;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.Gestores.Gestor;
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
        String user = appGestor.getUsername("manu1");
        System.out.println(user);

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
