package casoestudio.Fabrica_Abstracta;

import casoestudio.producto_abstracto._Usuario;

public interface Usuarios {

    public _Usuario crearUsuario(String _nombre, String _apellido1, String _apellido2, String numTel);

}
