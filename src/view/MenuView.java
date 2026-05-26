package view;

import model.Biblioteca;

public class MenuView {

    public static void mostrarMenuPrincipal() {

        System.out.println("\n=================================");
        System.out.println("      SISTEMA BIBLIOTECA");
        System.out.println("=================================");

        System.out.println("Livros cadastrados: " + Biblioteca.quantidadeLivros);

        System.out.println("---------------------------------");

        System.out.println("1 - Adicionar Novo Livro");
        System.out.println("2 - Pesquisar Livro");
        System.out.println("3 - Realizar Empréstimo");
        System.out.println("4 - Realizar Devolução");
        System.out.println("5 - Listar Livros");
        System.out.println("6 - Excluir Livro");
        System.out.println("7 - Sair");

        System.out.print("Escolha uma opção: ");
    }

    public static void mostrarSubMenu() {

        System.out.println("\n=================================");
        System.out.println("         LISTAR LIVROS");
        System.out.println("=================================");

        System.out.println("1 - Todos");
        System.out.println("2 - Disponíveis");
        System.out.println("3 - Por Autor");
        System.out.println("4 - Voltar");

        System.out.print("Escolha uma opção: ");
    }
}