package model;

import java.util.ArrayList;

public class Biblioteca {

    // ArrayList permite guardar livros e revistas juntos usando o tipo base Material.
    private ArrayList<Material> materiais = new ArrayList<>();

    // Recebe qualquer objeto que herde de Material, como Livro ou Revista.
    public void adicionar(Material material) {
        materiais.add(material);
    }

    // Percorre a lista procurando um material com o titulo informado.
    public Material pesquisarPorTitulo(String titulo) {
        for (Material material : materiais) {
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                return material;
            }
        }

        return null;
    }

    // Exclui o material reaproveitando a pesquisa por titulo.
    public boolean excluirPorTitulo(String titulo) {
        Material material = pesquisarPorTitulo(titulo);

        if (material == null) {
            return false;
        }

        materiais.remove(material);
        return true;
    }

    // Lista todos os materiais usando o toString especifico de cada classe.
    public void listarTodos() {
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
            return;
        }

        for (int i = 0; i < materiais.size(); i++) {
            System.out.println("[ID: " + (i + 1) + "] " + materiais.get(i));
        }
    }
}
