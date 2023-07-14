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

    public abstract void construirMotor();
    public abstract void construirPropulsores();


}
