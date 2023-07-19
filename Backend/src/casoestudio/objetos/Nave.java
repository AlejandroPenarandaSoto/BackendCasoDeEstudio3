package casoestudio.objetos;

import casoestudio.producto_Concreto._Usuarios;

public class Nave {

   private String codigo;
   private String color;
   private int idCat;
   private int marcaM;
   private String nombreU;


   public Nave(String codigo, String color, int idCat, int marcaM, String nombreU) {
      this.codigo = "NA";
      this.color = "NA";
      this.idCat = idCat;
      this.marcaM=marcaM;
      this.nombreU = nombreU;
   }

   public Nave() {
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

   public int getIdCat() {
      return idCat;
   }

   public void setIdCat(int idCat) {
      this.idCat = idCat;
   }

   public int getMarcaM() {
      return marcaM;
   }

   public void setMarcaM(int marcaM) {
      this.marcaM = marcaM;
   }

   public String getNombreU() {
      return nombreU;
   }

   public void setNombreU(String nombreU) {
      this.nombreU = nombreU;
   }

   @Override
   public String toString() {
      return "Nave{" +
              "codigo='" + codigo + '\'' +
              ", color='" + color + '\'' +
              ", idCat=" + idCat +
              ", marcaM=" + marcaM +
              ", nombreU='" + nombreU + '\'' +
              '}';
   }
}
