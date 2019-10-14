  *****************************************************************************************************************
  **                                      Gerenciamento Biblioteca                                               **
  *****************************************************************************************************************


    GitHub do Projeto: https://github.com/daniel-libanori/GerenciamentoBiblioteca
    Autor: Daniel Augusto Libanori
    Data: 14 de Outubro de 2019
  
    1)Resumo Técnico
    2)Funcionalidades
    3)Estrutura do Banco de Dados
    4)Estrutura do Projeto
  
  *****************************************************************************************************************
  **                                            1 - RESUMO TÉCNICO                                               **
  *****************************************************************************************************************
  
      
      DataBase Usado: SQLite
      Interface: Terminal
      Funcionalidades Resumo: Todas Implementadas e Funcionais
      
      Arquivo .db : Pasta principal do projeto
      Arquivos Conector SQLite: Cópia dentro da Pasta Scr
      
      IDE Utilizada: Itellij Community
      Versão Java SDK: 12
      
      Notas:
        - Sistema cria as tabelas caso elas não existam ou caso o arquivo .db seja excluido.
      
     
  *****************************************************************************************************************
  **                                           2 - FUNCIONALIDADES                                               **
  *****************************************************************************************************************
    
    F1 - Os dados de livro devem ser armazenados em uma base de dados relacional (postgres, mysql, sqlserver etc.)
       R: Utilizado SQLite
       
    F2 - Os dados de outras entidades podem ser armazenados em listas em memória (quem desejar, pode armazená-los no banco também).
       R: Utilizado SQLite
       
    F3 - Deve ser possível cadastrar livros: incluir livros, alterar livros, excluir livros, listar livros, buscar livros pelo ISBN, por parte do título e pela editora.Cada livro deve conter informações acerca de: autores, edição, editora, nome, ano.
       R: Implementado e Funcional
       
    F4 - Deve ser possível cadastrar usuários: incluir usuários, excluir usuários, listar usuários, buscar usuários por parte do nome e pelo login.
       R: Implementado e Funcional, foi considerado o ID do usuário como Login.
       
    F5 - Deve ser possível efetuar empréstimos: emprestar livros, renovar empréstimo, devolver livros, listar empréstimos, buscar empréstimos por livro (ISBN e título), por exemplar de livro e por usuário.
       R: Implementado e Funcional
       
    F6 - Deve ser possível efetuar reservas de livros: solicitar reserva de livro, cancelar reserva de livro.
       R: Implementado e Funcional
       
    F7 - Deve ser possível pagar multas pendentes.
       R: Implementado e Funcional
       
    F8 - Os alunos podem retirar até 3 livros, por uma semana. Os professores podem retirar até 5 livros, por 15 dias.
       R: Implementado e Funcional
       
    F9 - Os empréstimos são renovados pelo mesmo período permitido para o usuário em questão, não sendo permitidos, no entanto, renovações de livros que estão com o exemplar reservado por algum usuário. 
       R: Implementado e Funcional
       
    F10 - Usuários com multas só podem ter um único livro emprestado.
       R: Implementado e Funcional
       
    F11 - Não é permitido aos usuários com multas reservarem livros.
       R: Implementado e Funcional
       
    F12 - A multa é de R$ 1,00 por dia (útil ou não útil)
       R: Implementado e Funcional
       
       
       
  *****************************************************************************************************************
  **                                     3 - ESTRUTURA BANCO DE DADOS                                            **
  *****************************************************************************************************************
  
    -emprestimos
         -emprestimo_id (INTEGER PRIMARY KEY)
         -devolvido (BOOLEAN)
         -possivelRenovar (BOOLEAN)
         -exemplar_id (INTEGER)
         -user_id (INTEGER)
         -diaEmprestimo (INTEGER)
         -mesEmprestimo (INTEGER)
         -anoEmprestimo (INTEGER)
         -diaDevolucao (INTEGER)
         -mesDevolucao (INTEGER)
         -anoDevolucao (INTEGER)
         -ISBN (INTEGER)
         -nomeLivro (STRING)
     
     -exemplares
          -exemplar_id (INTEGER PRIMARY KEY)
          -ISBN (INTEGER)
          -disponivel (BOOLEAN)
          
     -livros
          -ISBN (INTEGER PRIMARY KEY)
          -nome (STRING)
          -autor (STRING)
          -editora (STRING)
          -ano (INTEGER)
          -edicao (INTEGER)
          -exemplares (INTEGER)
          -disponiveis (INTEGER)
          -reservado (BOOLEAN)
     
     -reservas
          -reserva_id (INTEGER PRIMARY KEY)
          -ISBN (INTEGER)
          -user_id (INTEGER)
          -reservaAtiva (BOOLEAN)
     
     -usuarios
          -user_id (INTEGER)
          -nome (STRING)
          -maximoEmprestimos (INTEGER)
          -emprestimosAtuais (INTEGER)
          -multa (INTEGER)
  
  
  *****************************************************************************************************************
  **                                        4 - ESTRUTURA DO PROJETO                                             **
  *****************************************************************************************************************
  
      Package Interface Terminal
          - company
              - Main
          - menu
              - Geral
  
      Packages Funcionalidades
          - acoes
              - Emprestar
              - Pagamento
              - Reserva
          - buscas
              - Busca
              - Lista
          - gerenciamento
              - Alterar
              - Excluir
              - Inserir
      
      Package Entidades
          - principal
              - Emprestimo
              - Exemplar
              - Livro
              - Usuario
              
      Package Banco de Dados
          - banco_de_dados
              - ConexaoSQLite
              - CriarTabelas
      
      Package Auxilio Funcionalidades
          - auxiliar
              - Auxilio
      
              
  *****************************************************************************************************************
  **                                            5 - NOTAS FINAIS                                                 **
  *****************************************************************************************************************
       
      Nota 1
          Certifique-se de que o connector está devidamente adicionado às bibliotecas do projeto.
          A adição da biblioteca pode variar conforme a IDE utilizda
          
      Nota 2
          Dependendo da sua IDE pode ser necessário a utilização de algum plugin para a conexão com o banco de dados.
          
          
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
  

    
     
  





