package casoestudio.constructores;

public class ConstructorConcreto extends Builder {
    public ConstructorConcreto() {
    }

    @Override
    public void construirMotor() {
        this.nave.setMotor("");
    }

    @Override
    public void construirPropulsores() {
        this.nave.setPropulsores("");
    }


}
