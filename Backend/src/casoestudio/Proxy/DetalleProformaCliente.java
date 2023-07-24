package casoestudio.Proxy;

public class DetalleProformaCliente implements IDetalleProformaCliente {

    private ProxyDAO proxyDAO = new ProxyDAO();

    @Override
    public int filtroCliente(String contrasenna) {
        return proxyDAO.getClienteId(contrasenna);
    }

}
