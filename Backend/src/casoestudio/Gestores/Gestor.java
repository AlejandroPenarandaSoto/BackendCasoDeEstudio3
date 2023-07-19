package casoestudio.Gestores;

import casoestudio.objetos.*;

import java.util.ArrayList;

public class Gestor {
    private CategoriaDAO catDAO;
    private MarcaDAO marDAO;
    private ModeloDAO modDAO;
    private MarcaModeloDAO mmDAO;

    public Gestor() {
    }

    public Gestor(CategoriaDAO catDAO, MarcaDAO marDAO, ModeloDAO modDAO, MarcaModeloDAO mmDAO) {
        this.catDAO = catDAO;
        this.marDAO = marDAO;
        this.modDAO = modDAO;
        this.mmDAO = mmDAO;
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

    public  void registrarMarcas(String nombre) {
        Marca tmpMarca = new Marca(nombre);
        MarcaDAO dao = new MarcaDAO();
        dao.registrarMarca(tmpMarca);
    }
}
