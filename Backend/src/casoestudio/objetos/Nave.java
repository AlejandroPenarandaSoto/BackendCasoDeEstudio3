package casoestudio.objetos;

import casoestudio.producto_Concreto._Usuarios;

public class Nave {
   private int idNave;
   private String codigo;
   private String color;
   private String motor;
   private String propulsores;
   private _Usuarios id_usuario;
   private MarcaModelo marcaM;
   private Categoria catN;

   public Nave(int idNave, String codigo, String color, String motor, String propulsores, _Usuarios id_usuario, MarcaModelo marcaM, Categoria catN) {
      this.idNave = idNave;
      this.codigo = codigo;
      this.color = color;
      this.motor = motor;
      this.propulsores = propulsores;
      this.id_usuario = id_usuario;
      this.marcaM = marcaM;
      this.catN = catN;
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

   public _Usuarios getId_usuario() {
      return id_usuario;
   }

   public void setId_usuario(_Usuarios id_usuario) {
      this.id_usuario = id_usuario;
   }

   public MarcaModelo getMarcaM() {
      return marcaM;
   }

   public void setMarcaM(MarcaModelo marcaM) {
      this.marcaM = marcaM;
   }

   public Categoria getCatN() {
      return catN;
   }

   public void setCatN(Categoria catN) {
      this.catN = catN;
   }

   @Override
   public String toString() {
      return "Nave{" +
              "idNave=" + idNave +
              ", codigo='" + codigo + '\'' +
              ", color='" + color + '\'' +
              ", motor='" + motor + '\'' +
              ", propulsores='" + propulsores + '\'' +
              ", id_usuario=" + id_usuario +
              ", marcaM=" + marcaM +
              ", catN=" + catN +
              '}';
   }
}
