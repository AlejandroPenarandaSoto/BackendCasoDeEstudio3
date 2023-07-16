package casoestudio.producto_Concreto;

import casoestudio.producto_abstracto._Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class GestorPrueba {


        private _UsuarioDAO usuarioDAO;


    public GestorPrueba() {
        usuarioDAO = new _UsuarioDAO();
    }


public ArrayList<_Usuarios> listarUsuarios() throws SQLException, ClassNotFoundException {
        return  new ArrayList<>(usuarioDAO.listarUsuarios()) ;
        }

    }


