package casoestudio.directores;

import casoestudio.constructores.Builder;

public class Director {
    private Builder builder;

    public Director() {
    }

    public void construirNave() {
        this.builder.crearNuevaNave();
        this.builder.construirCodigo();
        this.builder.construirColor();
        this.builder.construirUsuario();
        this.builder.construiridMarca();
        this.builder.construiridCategoria();
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Builder getBuilder() {
        return this.builder;
    }


}
