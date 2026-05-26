package service;

import java.util.Scanner;

import model.Biblioteca;

public class EmprestimoService {

    // ==========================
    // REALIZAR EMPRÉSTIMO
    // ==========================

    public static void realizarEmprestimo(Scanner scanner) {

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();

        if (titulo.isEmpty() || usuario.isEmpty()) {

            System.out.println("Preencha todos os campos.");
            return;
        }

        int indice = LivroService.buscarIndiceLivro(titulo);

        if (indice == -1) {

            System.out.println("Livro não encontrado.");
            return;
        }

        if (Biblioteca.arrayStatus[indice] == Biblioteca.EMPRESTADO) {

            System.out.println("Livro já emprestado.");
            return;
        }

        int contador = 0;

        for (int i = 0; i < Biblioteca.quantidadeLivros; i++) {

            if (Biblioteca.arrayLocatarios[i]
                    .equalsIgnoreCase(usuario)) {

                contador++;
            }
        }

        if (contador >= 3) {

            System.out.println("Usuário atingiu o limite de empréstimos.");
            return;
        }

        Biblioteca.arrayStatus[indice] = Biblioteca.EMPRESTADO;

        Biblioteca.arrayLocatarios[indice] = usuario;

        Biblioteca.arrayPrazos[indice] = 7;

        System.out.println("Empréstimo realizado com sucesso!");
    }

    // ==========================
    // CALCULAR MULTA
    // ==========================

    public static double calcularMulta(int dias, int prazo) {

        if (dias <= prazo) {

            return 0;
        }

        return (dias - prazo) * 2.0;
    }

    // ==========================
    // REALIZAR DEVOLUÇÃO
    // ==========================

    public static void realizarDevolucao(Scanner scanner) {

        System.out.print("Digite o título do livro: ");

        String titulo = scanner.nextLine();

        int indice = LivroService.buscarIndiceLivro(titulo);

        if (indice == -1) {

            System.out.println("Livro não encontrado.");
            return;
        }

        if (Biblioteca.arrayStatus[indice] == Biblioteca.DISPONIVEL) {

            System.out.println("Livro já está disponível.");
            return;
        }

        System.out.print("Quantos dias se passaram? ");

        while (!scanner.hasNextInt()) {

            System.out.println("Digite apenas números.");
            scanner.nextLine();
        }

        int dias = scanner.nextInt();

        scanner.nextLine();

        if (dias < 0) {

            System.out.println("Número inválido.");
            return;
        }

        double multa = calcularMulta(dias,
                Biblioteca.arrayPrazos[indice]);

        if (multa > 0) {

            System.out.printf("Multa: R$ %.2f%n", multa);
        }

        Biblioteca.arrayStatus[indice] = Biblioteca.DISPONIVEL;

        Biblioteca.arrayLocatarios[indice] = "";

        Biblioteca.arrayPrazos[indice] = 0;

        System.out.println("Livro devolvido com sucesso!");
    }
}