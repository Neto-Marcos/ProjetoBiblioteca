package model;

public class Biblioteca {

    public static final int DISPONIVEL = 0;
    public static final int EMPRESTADO = 1;

    public static final int LIMITE_LIVROS = 100;

    public static String[] arrayTitulos = new String[LIMITE_LIVROS];

    public static String[] arrayAutores = new String[LIMITE_LIVROS];

    public static int[] arrayStatus = new int[LIMITE_LIVROS];

    public static String[] arrayLocatarios = new String[LIMITE_LIVROS];

    public static int[] arrayPrazos = new int[LIMITE_LIVROS];

    public static int quantidadeLivros = 0;
}