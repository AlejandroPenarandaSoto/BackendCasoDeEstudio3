package casoestudio.Composite;

import java.util.ArrayList;
import java.util.List;

public class GrupoComponente {


    private List<Componente> componentes = new ArrayList<>();

    public void agregar(Componente componente) {
        componentes.add(componente);
    }

    public void remover(Componente componente) {
        componentes.remove(componente);
    }


    public String getDescripcion() {
        StringBuilder descri = new StringBuilder();
        for (Componente componente : componentes) {
            descri.append(componente.getDescripcion()).append("\n");
        }
        return descri.toString();
    }


}
