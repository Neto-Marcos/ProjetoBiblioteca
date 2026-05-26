package service;

import java.util.Scanner;

import model.Biblioteca;
import view.LivroView;
import view.MenuView;

public class ListagemService {

    // ==========================
    // MENU LISTAGEM
    // ==========================

    public static void menuListagem(Scanner scanner) {

        int opcao;

        do {

            MenuView.mostrarSubMenu();

            while (!scanner.hasNextInt()) {

                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }

            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:

                    listarTodos();
                    break;

                case 2:

                    listarDisponiveis();
                    break;

                case 3:

                    listarPorAutor(scanner);
                    break;

                case 4:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);
    }

    // ==========================
    // LISTAR TODOS
    // ==========================

    public static void listarTodos() {

        if (Biblioteca.quantidadeLivros == 0) {

            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (int i = 0; i < Biblioteca.quantidadeLivros; i++) {

            LivroView.mostrarLivro(i);
        }
    }

    // ==========================
    // LISTAR DISPONÍVEIS
    // ==========================

    public static void listarDisponiveis() {

        boolean encontrou = false;

        for (int i = 0; i < Biblioteca.quantidadeLivros; i++) {

            if (Biblioteca.arrayStatus[i]
                    == Biblioteca.DISPONIVEL) {

                LivroView.mostrarLivro(i);

                encontrou = true;
            }
        }

        if (!encontrou) {

            System.out.println("Nenhum livro disponível.");
        }
    }

    // ==========================
    // LISTAR POR AUTOR
    // ==========================

    public static void listarPorAutor(Scanner scanner) {

        System.out.print("Digite o nome do autor: ");

        String autor = scanner.nextLine();

        boolean encontrou = false;

        for (int i = 0; i < Biblioteca.quantidadeLivros; i++) {

            if (Biblioteca.arrayAutores[i]
                    .equalsIgnoreCase(autor)) {

                LivroView.mostrarLivro(i);

                encontrou = true;
            }
        }

        if (!encontrou) {

            System.out.println("Nenhum livro encontrado.");
        }
    }
}