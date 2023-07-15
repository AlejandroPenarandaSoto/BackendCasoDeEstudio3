package casoestudio.objetos;

public class MarcaModelo {
    private int anio;
    private Marca marcaN;
    private Modelo modeloN;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Marca getMarcaN() {
        return marcaN;
    }

    public void setMarcaN(Marca marcaN) {
        this.marcaN = marcaN;
    }

    public Modelo getModeloN() {
        return modeloN;
    }

    public void setModeloN(Modelo modeloN) {
        this.modeloN = modeloN;
    }

    public MarcaModelo(int anio, Marca marcaN, Modelo modeloN) {
        this.anio = anio;
        this.marcaN = marcaN;
        this.modeloN = modeloN;
    }

    public MarcaModelo() {
    }

    @Override
    public String toString() {
        return "MarcaModelo{" +
                "anio=" + anio +
                ", marcaN=" + marcaN +
                ", modeloN=" + modeloN +
                '}';
    }
}
