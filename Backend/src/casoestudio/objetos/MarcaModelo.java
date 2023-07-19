package casoestudio.objetos;

import java.util.ArrayList;

public class MarcaModelo {
    private int id_marcaM;
    private int anio;
    private int marcaId;
    private int modeloId;

    public MarcaModelo(int anio) {
        this.anio = anio;
    }

    public MarcaModelo(int anio, int marcaId, int modeloId) {
        this.anio = anio;
        this.marcaId = marcaId;
        this.modeloId = modeloId;
    }

    public MarcaModelo(int id_marcaM, int anio, int marcaId, int modeloId) {
        this.id_marcaM = id_marcaM;
        this.anio = anio;
        this.marcaId = marcaId;
        this.modeloId = modeloId;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }


    public int getMarcaId() {
        return marcaId;
    }

    public int getId_marcaM() {
        return id_marcaM;
    }

    public void setId_marcaM(int id_marcaM) {
        this.id_marcaM = id_marcaM;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
    }

    public int getModeloId() {
        return modeloId;
    }

    public void setModeloId(int modeloId) {
        this.modeloId = modeloId;
    }

    @Override
    public String toString() {
        return "MarcaModelo{" +
                "anio=" + anio +
                ", marcaId=" + marcaId +
                ", modeloId=" + modeloId +
                '}';
    }
}
