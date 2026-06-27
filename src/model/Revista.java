package model;

// Revista herda titulo e autor da classe Material e adiciona o numero da edicao.
public class Revista extends Material {

    private int numero;

    public Revista(String titulo, String autor, int numero) {
        super(titulo, autor);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        // Sobrescreve a exibicao para identificar que o material e uma revista.
        return "Revista | " + super.toString() + " | Numero: " + numero;
    }
}
