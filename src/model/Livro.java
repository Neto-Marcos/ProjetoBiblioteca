package model;

// Livro herda titulo e autor da classe Material e adiciona o genero.
public class Livro extends Material {

    private Genero genero;

    public Livro(String titulo, String autor, Genero genero) {
        super(titulo, autor);
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        // Sobrescreve a exibicao para identificar que o material e um livro.
        return "Livro | " + super.toString() + " | Genero: " + genero;
    }
}
