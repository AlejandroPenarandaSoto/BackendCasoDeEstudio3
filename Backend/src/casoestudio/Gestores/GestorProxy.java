package casoestudio.Gestores;

import casoestudio.Proxy.DetalleProformaClienteProxy;

public class GestorProxy {
    private DetalleProformaClienteProxy proxy;

    public GestorProxy() {
        proxy = new DetalleProformaClienteProxy();
    }

    public int getClienteId(String contrasenna) {

        int clienteId = proxy.filtroCliente(contrasenna);

        return clienteId;
    }
}
