package casoestudio.objetos;

public class Nave {
   private int idNave;
   private String codigo;
   private String color;
   private String motor;
   private String propulsores;
   private Usuario id_usuario;

   public Nave(int idNave, String codigo, String color, String motor, String propulsores, Usuario id_usuario) {
      this.idNave = idNave;
      this.codigo = codigo;
      this.color = color;
      this.motor = motor;
      this.propulsores = propulsores;
      this.id_usuario = id_usuario;
   }

   public Nave() {
   }

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

   public Usuario getId_usuario() {
      return id_usuario;
   }

   public void setId_usuario(Usuario id_usuario) {
      this.id_usuario = id_usuario;
   }
}
