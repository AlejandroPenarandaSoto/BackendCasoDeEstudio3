package casoestudio.objetos;

import java.util.ArrayList;

public class Proforma {
    private ArrayList<Repuesto> lineasProformas;

    public Proforma(ArrayList<Repuesto> lineasProformas) {
        this.lineasProformas = lineasProformas;
    }

    public ArrayList<Repuesto> getLineasProformas() {
        return lineasProformas;
    }

    public void setLineasProformas(ArrayList<Repuesto> lineasProformas) {
        this.lineasProformas = lineasProformas;
    }

    @Override
    public String toString() {
        return "Proforma{" +
                "lineasProformas=" + lineasProformas +
                '}';
    }
}
