package service;

import java.util.Scanner;

import model.Biblioteca;
import view.LivroView;

public class LivroService {

    // ==========================
    // BUSCAR ÍNDICE
    // ==========================

    public static int buscarIndiceLivro(String titulo) {

        for (int i = 0; i < Biblioteca.quantidadeLivros; i++) {

            if (Biblioteca.arrayTitulos[i].equalsIgnoreCase(titulo)) {

                return i;
            }
        }

        return -1;
    }

    // ==========================
    // ADICIONAR LIVRO
    // ==========================

    public static void adicionarLivro(Scanner scanner) {

        if (Biblioteca.quantidadeLivros >= Biblioteca.LIMITE_LIVROS) {

            System.out.println("Limite máximo de livros atingido.");
            return;
        }

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        if (titulo.isEmpty() || autor.isEmpty()) {

            System.out.println("Preencha todos os campos.");
            return;
        }

        if (buscarIndiceLivro(titulo) != -1) {

            System.out.println("Livro já cadastrado.");
            return;
        }

        int i = Biblioteca.quantidadeLivros;

        Biblioteca.arrayTitulos[i] = titulo;

        Biblioteca.arrayAutores[i] = autor;

        Biblioteca.arrayStatus[i] = Biblioteca.DISPONIVEL;

        Biblioteca.arrayLocatarios[i] = "";

        Biblioteca.arrayPrazos[i] = 0;

        Biblioteca.quantidadeLivros++;

        System.out.println("Livro adicionado com sucesso!");
    }

    // ==========================
    // PESQUISAR LIVRO
    // ==========================

    public static void pesquisarLivro(Scanner scanner) {

        System.out.print("Digite o título do livro: ");

        String titulo = scanner.nextLine();

        int indice = buscarIndiceLivro(titulo);

        if (indice == -1) {

            System.out.println("Livro não encontrado.");
            return;
        }

        LivroView.mostrarLivro(indice);
    }

    // ==========================
    // EXCLUIR LIVRO
    // ==========================

    public static void excluirLivro(Scanner scanner) {

        System.out.print("Digite o título do livro: ");

        String titulo = scanner.nextLine();

        int indice = buscarIndiceLivro(titulo);

        if (indice == -1) {

            System.out.println("Livro não encontrado.");
            return;
        }

        if (Biblioteca.arrayStatus[indice] == Biblioteca.EMPRESTADO) {

            System.out.println("Livro está emprestado.");
            return;
        }

        for (int i = indice; i < Biblioteca.quantidadeLivros - 1; i++) {

            Biblioteca.arrayTitulos[i] = Biblioteca.arrayTitulos[i + 1];

            Biblioteca.arrayAutores[i] = Biblioteca.arrayAutores[i + 1];

            Biblioteca.arrayStatus[i] = Biblioteca.arrayStatus[i + 1];

            Biblioteca.arrayLocatarios[i] = Biblioteca.arrayLocatarios[i + 1];

            Biblioteca.arrayPrazos[i] = Biblioteca.arrayPrazos[i + 1];
        }

        Biblioteca.quantidadeLivros--;

        System.out.println("Livro removido com sucesso!");
    }
}