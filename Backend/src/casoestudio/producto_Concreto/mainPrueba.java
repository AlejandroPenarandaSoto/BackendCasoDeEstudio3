package casoestudio.producto_Concreto;

import casoestudio.Fabrica_Abstracta.Usuarios;
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
        private static GestorPrueba appGestor = new GestorPrueba();

        public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

            appGestor.listarUsuarios();
            for (_Usuarios l:  appGestor.listarUsuarios())

                print(l.toString());
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
