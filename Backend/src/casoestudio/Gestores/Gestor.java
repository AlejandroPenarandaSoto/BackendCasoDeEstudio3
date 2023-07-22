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
    private ProformaDAO proformaDAO;
    private RechazoDAO rechazoDAO;

    public Gestor() {
    }

    public Gestor(CategoriaDAO catDAO, MarcaDAO marDAO, ModeloDAO modDAO, MarcaModeloDAO mmDAO) {
        this.catDAO = catDAO;
        this.marDAO = marDAO;
        this.modDAO = modDAO;
        this.mmDAO = mmDAO;
    }
    public void registrarUsuario(Usuarios ufabrica, String nombre, String apellido1, String apellido2, String cel, int rol_id , String user, String pswd){
        _Usuario tmpUser = ufabrica.crearUsuario(nombre,apellido1,apellido2,cel,rol_id, user,pswd);
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

    public void registrarProforma(String estado, int id_Cliente, int id_Vendedor) {
        Proforma tmpProforma = new Proforma(estado,id_Cliente,id_Vendedor);
        ProformaDAO dao = new ProformaDAO();
        dao.insertarProforma(tmpProforma);
    }

    public void registrarRazonRechazo(String descripcion) {
        Rechazo tmpRechazo = new Rechazo(descripcion);
        RechazoDAO dao = new RechazoDAO();
        dao.insertarRazonRechazo(tmpRechazo);
    }

    public int getUsuarioIdByUser(String username){
        int id = 0;
        _UsuarioDAO dao = new _UsuarioDAO();
         id = dao.getUsuarioIdByUsername(username);

         return id;
    }

    public String getUsername(String _user){
        String user = " ";
        _UsuarioDAO dao = new _UsuarioDAO();
        dao.getUsername(_user);
        return user;
    }

    public String getPswd(String _pswd){
        String pswd = " ";
        _UsuarioDAO dao = new _UsuarioDAO();
        dao.getPswd(_pswd);
        return pswd;
    }


}
