package app;

import java.util.Scanner;

import model.Biblioteca;
import model.Genero;
import model.Livro;
import model.Material;
import model.Revista;

public class Main {

    // Objeto responsavel por guardar e gerenciar todos os materiais cadastrados.
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            mostrarMenu();
            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    adicionarLivro(scanner);
                    break;
                case 2:
                    adicionarRevista(scanner);
                    break;
                case 3:
                    pesquisarMaterial(scanner);
                    break;
                case 4:
                    excluirMaterial(scanner);
                    break;
                case 5:
                    biblioteca.listarTodos();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        // Menu principal apresentado ao usuario no console.
        System.out.println();
        System.out.println("=================================");
        System.out.println("      SISTEMA BIBLIOTECA");
        System.out.println("=================================");
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Adicionar Revista");
        System.out.println("3 - Pesquisar Material por Titulo");
        System.out.println("4 - Excluir Material");
        System.out.println("5 - Listar Materiais");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void adicionarLivro(Scanner scanner) {
        // Coleta os dados especificos de um livro e cadastra na biblioteca.
        System.out.print("Digite o titulo do livro: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine().trim();

        if (titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos obrigatorios.");
            return;
        }

        Genero genero = escolherGenero(scanner);
        biblioteca.adicionar(new Livro(titulo, autor, genero));
        System.out.println("Novo material cadastrado com sucesso!");
    }

    private static void adicionarRevista(Scanner scanner) {
        // Coleta os dados especificos de uma revista e cadastra na biblioteca.
        System.out.print("Digite o titulo da revista: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Digite o autor da revista: ");
        String autor = scanner.nextLine().trim();

        if (titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos obrigatorios.");
            return;
        }

        System.out.print("Digite o numero da revista: ");
        int numero = lerInteiro(scanner);

        biblioteca.adicionar(new Revista(titulo, autor, numero));
        System.out.println("Novo material cadastrado com sucesso!");
    }

    private static void pesquisarMaterial(Scanner scanner) {
        // Pesquisa usando o titulo, sem diferenciar se o material e livro ou revista.
        System.out.print("Digite o titulo para pesquisar: ");
        String titulo = scanner.nextLine().trim();

        Material material = biblioteca.pesquisarPorTitulo(titulo);

        if (material == null) {
            System.out.println("Material nao encontrado.");
            return;
        }

        System.out.println(material);
    }

    private static void excluirMaterial(Scanner scanner) {
        // Remove o primeiro material encontrado com o titulo informado.
        System.out.print("Digite o titulo para excluir: ");
        String titulo = scanner.nextLine().trim();

        if (biblioteca.excluirPorTitulo(titulo)) {
            System.out.println("Material excluido com sucesso!");
        } else {
            System.out.println("Operacao falhou: titulo nao encontrado.");
        }
    }

    private static Genero escolherGenero(Scanner scanner) {
        // Mostra os valores do enum Genero e retorna a escolha do usuario.
        Genero[] generos = Genero.values();

        System.out.println("Escolha o genero:");
        for (int i = 0; i < generos.length; i++) {
            System.out.println((i + 1) + " - " + generos[i]);
        }

        int opcao = lerInteiro(scanner);

        if (opcao < 1 || opcao > generos.length) {
            return Genero.OUTRO;
        }

        return generos[opcao - 1];
    }

    private static int lerInteiro(Scanner scanner) {
        // Garante que o programa nao quebre quando o usuario digitar texto.
        while (!scanner.hasNextInt()) {
            System.out.println("Digite apenas numeros.");
            scanner.nextLine();
        }

        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }
}
