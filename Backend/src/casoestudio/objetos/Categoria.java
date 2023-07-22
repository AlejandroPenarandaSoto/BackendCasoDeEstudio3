package casoestudio.objetos;

import casoestudio.Composite.Componente;

public class Categoria  implements Componente {
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    public Categoria() {
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "categoria='" + categoria + '\'' +
                '}';
    }

    @Override
    public String getDescripcion() {
        return "Categoría: " + getCategoria();
    }
}
