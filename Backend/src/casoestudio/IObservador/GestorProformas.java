package casoestudio.IObservador;

import casoestudio.objetos.Proforma;
import casoestudio.producto_Concreto._Usuarios;

import java.util.ArrayList;
import java.util.List;

public class GestorProformas {



        private List<Proforma> proformasPendientes = new ArrayList<>();
        private List<_Usuarios> vendedores = new ArrayList<>();

        // Método para agregar proformas pendientes y notificar a los vendedores suscritos.
        public void agregarProformaPendiente(Proforma proforma) {
            proformasPendientes.add(proforma);
            notificarVendedores("Nueva proforma pendiente: " + proforma.getId_Proforma());
        }

        // Método para suscribir un vendedor como observador de las actualizaciones de proformas.
        public void suscribirVendedor(_Usuarios vendedor) {
            vendedores.add(vendedor);
        }

        // Método para desuscribir un vendedor de las actualizaciones de proformas.
        public void desuscribirVendedor(_Usuarios vendedor) {
            vendedores.remove(vendedor);
        }

        // Método para notificar a los vendedores suscritos sobre un cambio en las proformas.
        private void notificarVendedores(String mensaje) {
            for (_Usuarios vendedor : vendedores) {
                if (vendedor.getRol_id() == 2) {
                    vendedor.actualizarProforma(mensaje);
                }
            }
        }
}


