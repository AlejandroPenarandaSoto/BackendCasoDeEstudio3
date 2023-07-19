package casoestudio.producto_abstracto;

import casoestudio.objetos.Proforma;

public interface _Usuario {

    public String get_info_usuario();

    public  int generarRolID();

    public String getRol();


    void actualizarProforma(Proforma proforma);
}
