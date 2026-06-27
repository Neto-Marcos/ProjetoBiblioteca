# Projeto Biblioteca

Sistema simples de gerenciamento de biblioteca feito em Java para console.

Esta versao segue a proposta com orientacao a objetos:

- classe abstrata `Material`;
- classe `Livro`, que herda de `Material`;
- classe `Revista`, que herda de `Material`;
- enum `Genero`;
- classe `Biblioteca`, que usa `ArrayList<Material>`.

## Funcionalidades

- Adicionar livros
- Adicionar revistas
- Pesquisar material por titulo
- Excluir material por titulo
- Listar todos os materiais cadastrados
- Validar campos obrigatorios
- Exibir feedback em todas as operacoes

## Como abrir no IntelliJ

1. Abra o IntelliJ IDEA.
2. Clique em `Open`.
3. Selecione a pasta `ProjetoBiblioteca`.
4. Abra o arquivo `src/app/Main.java`.
5. Clique no botao de executar ao lado do metodo `main`.

## Como executar pelo terminal

```bash
javac -d out src/app/Main.java src/model/*.java
java -cp out app.Main
```

## Estrutura

```text
src/
  app/
    Main.java
  model/
    Biblioteca.java
    Genero.java
    Livro.java
    Material.java
    Revista.java
```
