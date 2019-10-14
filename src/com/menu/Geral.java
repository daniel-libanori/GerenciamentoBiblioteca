package com.menu;

import com.acoes.Emprestar;
import com.acoes.Pagamento;
import com.acoes.Reserva;
import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;
import com.buscas.Busca;
import com.buscas.Lista;
import com.gerenciamento.Alterar;
import com.gerenciamento.Excluir;
import com.gerenciamento.Inserir;

import java.util.Scanner;

public class Geral{

    public static void menuGeral(ConexaoSQLite conexaoSQLite){
        int acaoMenu;
        Scanner ler = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        while(true) {

            Auxilio.LimpaTela();

            System.out.println("Escolha a ação desejada: ");
            System.out.println("1 - Gerenciamento ");
            System.out.println("2 - Busca");
            System.out.println("3 - Ações");
            System.out.println(("0 - Sair"));

            acaoMenu = ler.nextInt();
            Auxilio.LimpaTela();
            switch (acaoMenu){
                case 1:
                    System.out.println("Escolha a ação desejada: ");
                    System.out.println("  - Gerenciamento ");
                    System.out.println("\t1 - Livros");
                    System.out.println("\t2 - Exemplares");
                    System.out.println("\t3 - Usuários");
                    System.out.println("\t0 - Voltar");
                    System.out.println("  - Busca");
                    System.out.println("  - Ações");
                    System.out.println(("  - Sair"));
                    acaoMenu = ler.nextInt();
                    Auxilio.LimpaTela();
                    if(acaoMenu<=2) gerenciamento(conexaoSQLite,acaoMenu);
                    break;

                case 2:
                    System.out.println("Escolha a ação desejada: ");
                    System.out.println("  - Gerenciamento ");
                    System.out.println("  - Busca");
                    System.out.println("\t1 - Livros");
                    System.out.println("\t2 - Usuários");
                    System.out.println("\t3 - Exemplares");
                    System.out.println("\t4 - Emprestimos");
                    System.out.println("\t0 - Voltar");
                    System.out.println("  - Ações");
                    System.out.println(("  - Sair"));
                    acaoMenu = ler.nextInt();
                    Auxilio.LimpaTela();
                    if(acaoMenu<=4) buscaMenu(conexaoSQLite,acaoMenu);
                    break;

                case 3:
                    System.out.println("Escolha a ação desejada: ");
                    System.out.println("  - Gerenciamento ");
                    System.out.println("  - Busca");
                    System.out.println("  - Ações");
                    System.out.println("\t1 - Emprestimos");
                    System.out.println("\t2 - Reservas");
                    System.out.println("\t3 - Multas");
                    System.out.println("\t0 - Voltar");
                    System.out.println(("  - Sair"));
                    acaoMenu = ler.nextInt();
                    Auxilio.LimpaTela();
                    if(acaoMenu<=3) acoesMenu(conexaoSQLite,acaoMenu);
                    break;

                default:
                    acaoMenu = -1;
                    break;

            }

            if(acaoMenu==-1) break;

        }//while_end

    }


    public static void gerenciamento(ConexaoSQLite conexaoSQLite, int a){
        Scanner ler = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        if(a==1){
            System.out.println("\tMenu de Gerenciamento de Livros");
            System.out.println("\t1 - Incluir Livro");
            System.out.println("\t2 - Alterar Livro");
            System.out.println("\t3 - Excluir Livro");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Inserir.inserirLivro(conexaoSQLite);
                    break;
                case 2:
                    Alterar.alterarLivro(conexaoSQLite);
                    break;
                case 3:
                    Excluir.excluirLivro(conexaoSQLite);
                    break;
                default: break;
            }


        }else if (a==2) {
            System.out.println("\tMenu de Gerenciamento de Exemplar");
            System.out.println("\t1 - Incluir Exemplar");
            System.out.println("\t2 - Excluir Exemplar");
            System.out.println("\t0 - Voltar");
            a = ler.nextInt();
            Auxilio.LimpaTela();

            switch (a) {
                case 1:
                    Inserir.inserirExemplar(conexaoSQLite);
                    break;
                case 2:
                    Excluir.excluirExemplar(conexaoSQLite);
                    break;
                default: break;
            }
        }else if (a==3){
            System.out.println("\tMenu de Gerenciamento de Usuario");
            System.out.println("\t1 - Incluir Usuario");
            System.out.println("\t2 - Alterar Usuario");
            System.out.println("\t3 - Excluir Usuario");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Inserir.inserirUsuario(conexaoSQLite);
                    break;
                case 2:
                    Alterar.alterarUsuario(conexaoSQLite);
                    break;
                case 3:
                    Excluir.excluirUsuario(conexaoSQLite);
                    break;
                default: break;
            }
        }

    }


    public static void buscaMenu(ConexaoSQLite conexaoSQLite, int a){
        Scanner ler = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        if(a==1){
            System.out.println("\tMenu de Busca de Livros");
            System.out.println("\t1 - Listar Todos os Livro");
            System.out.println("\t2 - Buscar Livro pelo ISBN");
            System.out.println("\t3 - Buscar Livro pelo Nome");
            System.out.println("\t4 - Buscar Livro pela Editora");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Lista.livro_listarTodos(conexaoSQLite);
                    break;
                case 2:
                    Busca.buscar_livroISBN(conexaoSQLite);
                    break;
                case 3:
                    Busca.buscar_livroNome(conexaoSQLite);
                    break;
                case 4:
                    Busca.buscar_livroEditora(conexaoSQLite);
                    break;
                default: break;
            }


        }else if (a==2) {
            System.out.println("\tMenu de Busca de Usuario");
            System.out.println("\t1 - Listar Todos os Usuários");
            System.out.println("\t2 - Buscar Usuário pelo ID");
            System.out.println("\t3 - Buscar Usuário pelo Nome");
            System.out.println("\t0 - Voltar");
            a = ler.nextInt();
            Auxilio.LimpaTela();

            switch (a) {
                case 1:
                    Lista.usuario_listarTodos(conexaoSQLite);
                    break;
                case 2:
                    Busca.buscar_usuarioID(conexaoSQLite);
                    break;
                case 3:
                    Busca.buscar_usuarioNome(conexaoSQLite);
                    break;
                default: break;
            }
        }else if (a==3){
            System.out.println("\tMenu de Busca de Exemplar");
            System.out.println("\t1 - Buscar Exemplar por ID");
            System.out.println("\t2 - Buscar Exemplar por ISBN");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Busca.buscar_exemplarID(conexaoSQLite);
                    break;
                case 2:
                    Busca.buscar_exemplarISBN(conexaoSQLite);
                    break;
                default: break;
            }
        }else if (a==4){
            System.out.println("\tMenu de Busca de Emprestimo");
            System.out.println("\t1 - Listar todos os Emprestimos Ativos");
            System.out.println("\t2 - Buscar Emprestimos de um Usuário");
            System.out.println("\t3 - Buscar Emprestimos por ISBN");
            System.out.println("\t4 - Buscar Emprestimos por nome do Livro");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Lista.emprestimos_listaTodos(conexaoSQLite);
                    break;
                case 2:
                    Busca.buscar_emprestimosUsuario(conexaoSQLite);
                    break;
                case 3:
                    Busca.emprestimos_buscaPorISBN(conexaoSQLite);
                    break;
                case 4:
                    Busca.buscar_emprestimoNome(conexaoSQLite);
                    break;
                default: break;
            }
        }

    }


    public static void acoesMenu(ConexaoSQLite conexaoSQLite, int a){
        Scanner ler = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        if(a==1){
            System.out.println("\tMenu de Ações de Emprestimo");
            System.out.println("\t1 - Emprestar Livro");
            System.out.println("\t2 - Renovar Emprestimo");
            System.out.println("\t3 - Devolver Livros");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Emprestar.realizarEmprestimo(conexaoSQLite);
                    break;
                case 2:
                    Emprestar.renovarEmprestimo(conexaoSQLite);
                    break;
                case 3:
                    Emprestar.devolverLivro(conexaoSQLite);
                    break;
                default: break;
            }


        }else if (a==2) {
            System.out.println("\tMenu de Ações de Reserva");
            System.out.println("\t1 - Solicitar Reserva");
            System.out.println("\t2 - Cancelar Reserva");
            System.out.println("\t0 - Voltar");
            a = ler.nextInt();
            Auxilio.LimpaTela();

            switch (a) {
                case 1:
                    Reserva.realizarReserva(conexaoSQLite);
                    break;
                case 2:
                    Reserva.cancelarReserva(conexaoSQLite);
                    break;
                default: break;
            }
        }else if (a==3){
            System.out.println("\tMenu de Ações de Multa");
            System.out.println("\t1 - Buscar Exemplar por ID");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();
            Auxilio.LimpaTela();

            switch (a){
                case 1:
                    Pagamento.pagarMulta(conexaoSQLite);
                    break;
                default: break;
            }
        }

    }










}
