package casoestudio.IObservador;

import casoestudio.objetos.DetalleProforma;
import casoestudio.objetos.Proforma;

public interface ObservadorProforma {
    void notificarNuevosDetalles (Proforma prof, DetalleProforma detalleProf);
}
