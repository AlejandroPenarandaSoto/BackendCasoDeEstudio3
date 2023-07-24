package casoestudio.Proxy;

public class DetalleProformaClienteProxy implements IDetalleProformaCliente{

    private ProxyDAO proxyDAO = new ProxyDAO();

    private boolean ejecutar = false;

    @Override
    public int filtroCliente(String contrasenna) {

        ejecutar = Validador.validarString(contrasenna);

        if (!ejecutar){
            return 0;
        }

        return proxyDAO.getClienteId(contrasenna);
    }

}
