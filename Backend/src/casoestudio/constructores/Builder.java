package casoestudio.constructores;

import casoestudio.objetos.Nave;


public abstract class Builder {
    protected Nave nave;

    public Builder() {
    }

    public Nave getNave() {
        return this.nave;
    }

    public void crearNuevaNave() {
        this.nave = new Nave();
    }



    public abstract void construirCodigo();

    public abstract void construirColor();

    public abstract void construiridCategoria();
    public abstract void construiridMarca();
    public abstract void construirUsuario();
}
