package casoestudio.objetos;

public class Nave {
   private int idNave;
   private String codigo;
   private String color;
   private String motor;
   private String propulsores;

    public int getIdNave() {
        return idNave;
    }

    public void setIdNave(int idNave) {
        this.idNave = idNave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPropulsores() {
        return propulsores;
    }

    public void setPropulsores(String propulsores) {
        this.propulsores = propulsores;
    }
}
