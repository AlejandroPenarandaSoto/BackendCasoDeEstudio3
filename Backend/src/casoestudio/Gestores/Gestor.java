package casoestudio.Gestores;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_Concreto._Usuarios;
import casoestudio.producto_abstracto._Usuario;

public class Gestor {
    private CategoriaDAO catDAO;
    private MarcaDAO marDAO;
    private ModeloDAO modDAO;
    private MarcaModeloDAO mmDAO;
    private _UsuarioDAO uDAO;
    private NaveDAO naveDAO;
    private ProformaDAO proformaDAO;
    private RechazoDAO rechazoDAO;
    private MarcaRepuestoDAO marcaRepuestoDAO;
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
    public  void registrarDetalleProf(int id_detalle, int id_proforma, int id_repuesto, String estado, int id_rechazo){
        DetalleProforma tmpDetalle = new DetalleProforma(id_proforma, id_repuesto, estado, id_rechazo, id_detalle);
        ProformaDetalleDAO dao = new ProformaDetalleDAO();
        dao.insertarDetalleProforma(tmpDetalle);
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

    public boolean Login(String user, String pswd){
        _UsuarioDAO dao = new _UsuarioDAO();
        dao.validateLogin(user,pswd);


        return false;
    }


    //funciones Luis

    public void listarMarcaRepuesto(){
        MarcaRepuestoDAO mr = new MarcaRepuestoDAO();
        mr.getMarcaRepuesto();
        mr.getMarcaRepuesto();
    }
    public  void registrarMarcaR(String nombre) {
        MarcaRepuesto tmpMarcaRepuesto = new MarcaRepuesto(nombre);
        MarcaRepuestoDAO mr = new MarcaRepuestoDAO();
        mr.registrarMarcaRepuesto(tmpMarcaRepuesto);
        mr.getMarcaRepuesto();
    }

    public  void registrarTipoR(String nombre) {
        TipoRepuesto tmpTipo = new TipoRepuesto(nombre);
        TipoRepuestoDAO tr = new TipoRepuestoDAO();
        tr.registrarTipoRepuesto(tmpTipo);
        tr.getTipoRepuesto();
    }


    public  void registrarRepuesto(int tipoR,String nombre, String descripcion,  String categoria, int precio,int marcaR) {
        Repuesto tmpRepuesto = new Repuesto(tipoR ,nombre,descripcion,categoria,precio,marcaR);
        RepuestoDAO rDAO = new RepuestoDAO();
        rDAO.registrarRepuesto(tmpRepuesto);
    }

    public  void listarRepuesto() {
        RepuestoDAO r = new RepuestoDAO();
        r.getRepuesto();

    }

    public Nave ObtenerNave(String nave) {

        NaveDAO nav = new NaveDAO();


        return  nav.getNaveDataUser(nave);
    }

    public _Usuarios ObtenerUsuario(String user) {
        _UsuarioDAO usuario = new _UsuarioDAO();


        return usuario.getDataUser(user);
    }

    public Categoria ObtenerCategoria(String ctg) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();


        return categoriaDAO.getDataCategoria(ctg);
    }





}
