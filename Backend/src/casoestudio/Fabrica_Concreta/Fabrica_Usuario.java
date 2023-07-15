package casoestudio.Fabrica_Concreta;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.producto_Concreto._Usuarios;
import casoestudio.producto_abstracto._Usuario;

public class Fabrica_Usuario implements Usuarios {



    @Override
    public _Usuario crearUsuario(String _nombre, String _apellido1, String _apellido2, String numTel) {
        _Usuarios tmpUser = new _Usuarios(_nombre,_apellido1,_apellido2,numTel);
        tmpUser.setRol_id(tmpUser.generarRolID());
        return tmpUser;
    }
}
