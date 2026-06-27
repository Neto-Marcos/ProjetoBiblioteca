package model;

// Classe base: guarda os dados comuns entre livros e revistas.
public abstract class Material {

    private String titulo;
    private String autor;

    public Material(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        // As subclasses reaproveitam este texto e adicionam suas informacoes proprias.
        return "Titulo: " + titulo + " | Autor: " + autor;
    }
}
