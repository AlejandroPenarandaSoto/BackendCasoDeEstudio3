package casoestudio.constructores;

import casoestudio.objetos.Nave;

public class ConstructorConcreto extends Builder {
    private Nave nave;

    public ConstructorConcreto() {
        nave = new Nave();
    }

    public void setCodigo(String codigo) {
        nave.setCodigo(codigo);
    }

    public void setColor(String color) {
        nave.setColor(color);
    }

    public void setIdCategoria(int idCategoria) {
        nave.setIdCat(idCategoria);
    }

    public void setIdMarca(int idMarca) {
        nave.setMarcaM(idMarca);
    }

    public void setIdUsuario(int idUsuario) {
        nave.setIdU(idUsuario);
    }

    @Override
    public void construirCodigo() {

    }

    @Override
    public void construirColor() {

    }

    @Override
    public void construiridCategoria() {

    }

    @Override
    public void construiridMarca() {

    }

    @Override
    public void construirUsuario() {

    }

    public Nave getNave() {
        return nave;
    }
}

