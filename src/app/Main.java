package app;

import java.util.Scanner;

import service.EmprestimoService;
import service.ListagemService;
import service.LivroService;
import view.MenuView;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            MenuView.mostrarMenuPrincipal();

            while (!scanner.hasNextInt()) {

                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    LivroService.adicionarLivro(scanner);
                    break;

                case 2:
                    LivroService.pesquisarLivro(scanner);
                    break;

                case 3:
                    EmprestimoService.realizarEmprestimo(scanner);
                    break;

                case 4:
                    EmprestimoService.realizarDevolucao(scanner);
                    break;

                case 5:
                    ListagemService.menuListagem(scanner);
                    break;

                case 6:
                    LivroService.excluirLivro(scanner);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 7);

        scanner.close();
    }
}