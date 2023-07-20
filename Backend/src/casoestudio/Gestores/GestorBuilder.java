package casoestudio.Gestores;

import casoestudio.constructores.ConstructorConcreto;
import casoestudio.directores.Director;
import casoestudio.objetos.Nave;

import java.util.ArrayList;

public class GestorBuilder {
    private static ArrayList<Nave> arrNaves = new ArrayList<>();
    private Director objDirector = new Director();

    public GestorBuilder() {
    }

    public void construccion_base(String codigo, String color, int idCategoria, int idMarca, int idUsuario) {
        ConstructorConcreto constructorConcreto = new ConstructorConcreto();
        constructorConcreto.setCodigo(codigo);
        constructorConcreto.setColor(color);
        constructorConcreto.setIdCategoria(idCategoria);
        constructorConcreto.setIdMarca(idMarca);
        constructorConcreto.setIdUsuario(idUsuario);
        this.objDirector.setBuilder(constructorConcreto);
        this.nueva_Nave();
    }

    public void nueva_Nave() {
        this.objDirector.construirNave();
        add_objeto_array(this.objDirector.getBuilder().getNave());
    }

    private static void add_objeto_array(Nave pObj) {
        arrNaves.add(pObj);
    }
    public Nave getNave() {
        return objDirector.getBuilder().getNave();
    }

    public Director getObjDirector() {
        return this.objDirector;
    }

    public void setObjDirector(Director objDirector) {
        this.objDirector = objDirector;
    }
}
