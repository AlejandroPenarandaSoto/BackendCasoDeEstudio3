package casoestudio.objetos;

public class MarcaModelo {
    private int marcaModelo;
    private int anio;

    public int getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(int marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public MarcaModelo(int marcaModelo, int anio) {
        this.marcaModelo = marcaModelo;
        this.anio = anio;
    }

    public MarcaModelo() {
    }

    @Override
    public String toString() {
        return "MarcaModelo{" +
                "marcaModelo=" + marcaModelo +
                ", anio=" + anio +
                '}';
    }
}
