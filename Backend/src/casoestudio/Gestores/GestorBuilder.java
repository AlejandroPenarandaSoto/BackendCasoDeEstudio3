package casoestudio.Gestores;

import casoestudio.constructores.ConstructorConcreto;
import casoestudio.directores.Director;
import casoestudio.objetos.Nave;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorBuilder {
    private static ArrayList<Nave> arrNaves = new ArrayList();
    private Director objDirector = new Director();

    public GestorBuilder() {
    }

    public void construccion_base() {
        ConstructorConcreto constructorConcreto = new ConstructorConcreto();
        this.objDirector.setBuilder(constructorConcreto);
        this.nueva_Nave();
    }


    private void nueva_Nave() {
        this.objDirector.construirNave();
        add_objeto_array(this.objDirector.getBuilder().getNave());
    }

    private static void add_objeto_array(Nave pObj) {
        arrNaves.add(pObj);
    }



    public String obtenerDatos() {
        String mResult = "";

        Nave mOb;
        for(Iterator var3 = arrNaves.iterator(); var3.hasNext(); mResult = mResult  +  "Color: " + mOb.getColor() + "\n"+ "Codigo: " + mOb.getCodigo() + "\n") {
            mOb = (Nave)var3.next();
        }

        return mResult;
    }

    public Director getObjDirector() {
        return this.objDirector;
    }

    public void setObjDirector(Director objDirector) {
        this.objDirector = objDirector;
    }
}
