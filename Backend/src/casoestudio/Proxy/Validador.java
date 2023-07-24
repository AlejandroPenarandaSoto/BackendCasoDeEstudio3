package casoestudio.Proxy;

public class Validador {

    public static boolean validarString(String contrasenna) {
        if (contrasenna != null && !contrasenna.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
