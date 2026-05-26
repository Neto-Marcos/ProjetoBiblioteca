package view;

import model.Biblioteca;

public class LivroView {

    public static void mostrarLivro(int i) {

        System.out.println("\n[ID: " + (i + 1) + "]");

        System.out.println("Título: " + Biblioteca.arrayTitulos[i]);

        System.out.println("Autor: " + Biblioteca.arrayAutores[i]);

        if (Biblioteca.arrayStatus[i] == Biblioteca.DISPONIVEL) {

            System.out.println("Status: Disponível");

        } else {

            System.out.println("Status: Emprestado para: "
                    + Biblioteca.arrayLocatarios[i]);

            System.out.println("Prazo restante: "
                    + Biblioteca.arrayPrazos[i] + " dias");
        }
    }
}