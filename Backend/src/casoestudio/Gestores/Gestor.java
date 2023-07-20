package casoestudio.Gestores;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_abstracto._Usuario;

import java.util.ArrayList;

public class Gestor {
    private CategoriaDAO catDAO;
    private MarcaDAO marDAO;
    private ModeloDAO modDAO;
    private MarcaModeloDAO mmDAO;
    private _UsuarioDAO uDAO;
    private NaveDAO naveDAO;

    public Gestor() {
    }

    public Gestor(CategoriaDAO catDAO, MarcaDAO marDAO, ModeloDAO modDAO, MarcaModeloDAO mmDAO) {
        this.catDAO = catDAO;
        this.marDAO = marDAO;
        this.modDAO = modDAO;
        this.mmDAO = mmDAO;
    }
    public void registrarUsuario(Usuarios ufabrica, String nombre, String apellido1, String apellido2, String cel, int rol_id){
        _Usuario tmpUser = ufabrica.crearUsuario(nombre,apellido1,apellido2,cel,rol_id);
        _UsuarioDAO dao = new _UsuarioDAO();
        dao.registrarUsuario(tmpUser);

    }

    public void listarUsuarios(){
        _UsuarioDAO dao = new _UsuarioDAO();
        dao.listarUsuarios();
    }


    public  void registrarCategorias(String nombre) {
        Categoria tmpCategoria = new Categoria(nombre);
        CategoriaDAO dao = new CategoriaDAO();
        dao.registrarCategoria(tmpCategoria);
    }
    public  void registrarModelos(String modelo) {
        Modelo tmpModelo = new Modelo(modelo);
        ModeloDAO dao = new ModeloDAO();
        dao.registrarModelo(tmpModelo);
    }
    public void registrarAnios(int anio, int marcaId, int modeloId) {
        MarcaModelo tmpAnio = new MarcaModelo(anio,marcaId, modeloId);
        MarcaModeloDAO dao = new MarcaModeloDAO();
        dao.registrarAnio(tmpAnio);
    }
    public void registrarNaves(String codigo, String color, int idCat, int marcaM, int idU) {
        Nave tmpNave = new Nave( codigo, color,idCat,marcaM,idU);
        NaveDAO naveDao = new NaveDAO();
        naveDao.registrarNave(tmpNave);
    }

    public  void registrarMarcas(String nombre) {
        Marca tmpMarca = new Marca(nombre);
        MarcaDAO dao = new MarcaDAO();
        dao.registrarMarca(tmpMarca);
    }
}
