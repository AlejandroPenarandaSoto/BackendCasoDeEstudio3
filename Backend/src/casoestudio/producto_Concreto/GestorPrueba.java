package casoestudio.producto_Concreto;

import casoestudio.objetos.Categoria;
import casoestudio.objetos.CategoriaDAO;
import casoestudio.producto_abstracto._Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class GestorPrueba {
    private  CategoriaDAO catDao;

    private _UsuarioDAO usuarioDAO;


    public GestorPrueba() {
        usuarioDAO = new _UsuarioDAO();
        catDao= new CategoriaDAO();
    }



    public  void registrarCategorias(String nombre) {
        Categoria tmpCategoria = new Categoria(nombre);
        CategoriaDAO dao = new CategoriaDAO();
        dao.registrarCategoria(tmpCategoria);
    }

}



