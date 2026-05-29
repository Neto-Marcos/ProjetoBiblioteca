# Projeto Biblioteca 📚

Um sistema de gerenciamento de biblioteca simples e eficiente, desenvolvido em Java. O projeto permite o cadastro de livros, controle de empréstimos, devoluções com cálculo de multa e diversas formas de listagem.

## 🚀 Funcionalidades

- **Cadastro de Livros:** Adicione novos títulos e autores ao acervo (limite de 100 livros).
- **Pesquisa de Livros:** Localize rapidamente um livro pelo título.
- **Sistema de Empréstimos:** 
    - Realize empréstimos informando o título do livro e o nome do usuário.
    - Limite de até 3 livros por usuário.
    - Prazo padrão de 7 dias para devolução.
- **Controle de Devoluções:**
    - Registro de devolução com cálculo automático de multa para atrasos (R$ 2,00 por dia).
- **Listagens Diversas:**
    - Listar todos os livros cadastrados.
    - Listar apenas livros disponíveis.
    - Listar livros por autor específico.
- **Gerenciamento de Acervo:** Exclusão de livros que não estejam emprestados.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Interface:** Console (CLI)

## 📁 Estrutura do Projeto

O projeto segue uma organização em pacotes para melhor manutenção:

- `app`: Contém a classe `Main`, ponto de entrada do sistema.
- `model`: Define a estrutura de dados e o "banco de dados" em memória (`Biblioteca.java`).
- `service`: Contém a lógica de negócio (Empréstimos, Listagens, Gerenciamento de Livros).
- `view`: Responsável pela interação com o usuário e exibição de menus.
- `util`: Classes utilitárias (Ex: `InputUtil.java`).

## ⚙️ Como Executar

1. Certifique-se de ter o **JDK (Java Development Kit)** instalado em sua máquina.
2. Clone o repositório:
   ```bash
   git clone https://github.com/Neto-Marcos/ProjetoBiblioteca.git
   ```
3. Navegue até o diretório do projeto:
   ```bash
   cd ProjetoBiblioteca
   ```
4. Compile os arquivos Java:
   ```bash
   javac -d out src/**/*.java
   ```
5. Execute a aplicação:
   ```bash
   java -cp out app.Main
   ```

## 📝 Licença

Este projeto é de uso acadêmico/educativo. Sinta-se à vontade para clonar e realizar melhorias!

---
Desenvolvido por [Neto Marcos](https://github.com/Neto-Marcos) e equipe.
