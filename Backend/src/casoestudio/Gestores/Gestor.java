package casoestudio.Gestores;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_Concreto._Usuarios;
import casoestudio.producto_abstracto._Usuario;

import java.util.List;

public class Gestor {
    private CategoriaDAO catDAO;
    private MarcaDAO marDAO;
    private ModeloDAO modDAO;
    private MarcaModeloDAO mmDAO;
    private _UsuarioDAO uDAO;
    private NaveDAO naveDAO;
    private ProformaDAO proformaDAO;
    private RechazoDAO rechazoDAO;
    private ProformaDetalleDAO proformaDetalleDAO;
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
    public  void registrarDetalleProf(int id_proforma, int id_repuesto, String estado, int id_rechazo){
        DetalleProforma tmpDetalle = new DetalleProforma(id_proforma, id_repuesto, estado, id_rechazo);
        ProformaDetalleDAO dao = new ProformaDetalleDAO();
        dao.insertarDetalleProforma(tmpDetalle);
    }

    public int getUsuarioIdByUser(String username){
        int id = 0;
        _UsuarioDAO dao = new _UsuarioDAO();
         id = dao.getIdRolByUsername(username);

         return id;
    }

    public int getUsuarioId(String username){
        int iduser = 0;
        _UsuarioDAO dao = new _UsuarioDAO();
        iduser = dao.getUsuariosId(username);

        return iduser;
    }




    public String getUsername(String _user){
        _UsuarioDAO dao = new _UsuarioDAO();
        String user =  dao.getUsername(_user);
        return user;
    }

    public String getPswd(String _pswd){
        _UsuarioDAO dao = new _UsuarioDAO();
        String pswd = dao.getPswd(_pswd);
        return pswd;
    }




    //funciones Luis

    public List<String> listarMarcaRepuesto(){
        MarcaRepuestoDAO mr = new MarcaRepuestoDAO();
        mr.getMarcaRepuesto();
         return mr.getMarcaRepuesto();
    }

    public List<String> listarTipoRepuesto(){
        TipoRepuestoDAO tr = new TipoRepuestoDAO();
        tr.getTipoRepuesto();
        return tr.getTipoRepuesto();
    }

    public int marcaRepuestoID(String marca){
        MarcaRepuestoDAO mr = new MarcaRepuestoDAO();
        mr.getMarcaRepuestoId(marca);
        return mr.getMarcaRepuestoId(marca);
    }
    public int tipoRepuestoID(String tipor){
        TipoRepuestoDAO tr = new TipoRepuestoDAO();
        tr.getTipoRepuestoId(tipor);
        return tr.getTipoRepuestoId(tipor);
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


    public  void registrarRepuesto(int tipoR,String nombre, String descripcion,  String categoria, int precio,int marcaR, int annio,int cantidad) {
        Repuesto tmpRepuesto = new Repuesto(tipoR ,nombre,descripcion,categoria,precio,marcaR,annio,cantidad);
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

    public Nave getNavelist(Integer idUser) {

        NaveDAO nav = new NaveDAO();


        return (Nave) nav.getNaveUser(idUser);
    }

    public _Usuarios ObtenerUsuario(String user) {
        _UsuarioDAO usuario = new _UsuarioDAO();


        return usuario.getDataUser(user);
    }

    public Categoria ObtenerCategoria(String ctg) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();


        return categoriaDAO.getDataCategoria(ctg);
    }

    public List<Proforma> getProformasByIdCliente(int idCliente) {
        ProformaDAO proformaDAO = new ProformaDAO();
        return proformaDAO.getProformasByIdCliente(idCliente);
    }

    public List<DetalleProforma> getDetalleProformaByProformaId(int idProforma) {
        ProformaDetalleDAO proformaDetalleDAO = new ProformaDetalleDAO();
        return proformaDetalleDAO.getDetallesfById(idProforma);
    }

}
