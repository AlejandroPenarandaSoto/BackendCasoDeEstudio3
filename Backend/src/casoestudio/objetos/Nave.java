package casoestudio.objetos;

import casoestudio.Composite.Componente;
import casoestudio.producto_Concreto._Usuarios;

public class Nave  implements Componente {

   private String codigo;
   private String color;
   private int idCat;
   private int marcaM;
   private int idU;


   public Nave(String codigo, String color, int idCat, int marcaM, int idU) {
      this.codigo = codigo;
      this.color = color;
      this.idCat = idCat;
      this.marcaM = marcaM;
      this.idU = idU;
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

   public int getIdU() {
      return idU;
   }

   public void setIdU(int idU) {
      this.idU = idU;
   }

   @Override
   public String toString() {
      return "Nave{" +
              "codigo='" + codigo + '\'' +
              ", color='" + color + '\'' +
              ", idCat=" + idCat +
              ", marcaM=" + marcaM +
              ", idU=" + idU +
              '}';
   }

   @Override
   public String getDescripcion() {
      return "Nave: " + getCodigo();
   }
}
