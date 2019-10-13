package com.gerenciamento;

import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Alterar {

    public static void alterarUsuario(ConexaoSQLite conexaoSQLite){


        Integer id_alteracao;
        String nome_alteracao;
        Scanner sc = new Scanner(System.in);


        conexaoSQLite.conectar();

        System.out.println("Digite o ID do usuário que deseja alterar o nome (ou-1 para sair): ");
        id_alteracao = sc.nextInt(); sc.nextLine();

        if(id_alteracao==-1) return;

        System.out.println("Digite o novo nome do usuario: ");
        nome_alteracao = sc.nextLine();



        String sql = "update usuarios set nome = ? where user_id = " +  id_alteracao.toString();
        try {

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);


            p.setString(1,nome_alteracao);
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


    }


    public static void alterarLivro(ConexaoSQLite conexaoSQLite){


        Integer id_alteracao;
        String string_alteracao="", sqlColuna;
        int int_alteracao=0, acao;

        Scanner sc = new Scanner(System.in);

        conexaoSQLite.conectar();

        System.out.println("Digite o ISBN do livro que deseja alterar o nome (ou-1 para sair): ");
        id_alteracao = sc.nextInt(); sc.nextLine();

        if(id_alteracao==-1) return;

        Auxilio.LimpaTela();
        System.out.println("\n 1 - Nome\n 2 - Autor\n 3 - Editora\n 4 - Ano \n 5 - Edição\n\n O que deseja alterar?");
        acao = sc.nextInt(); sc.nextLine();

        switch (acao){

            case 1:
                System.out.print("Digite o novo nome desejado:");
                string_alteracao = sc.nextLine();
                sqlColuna = "nome";
                break;
            case 2:
                System.out.print("Digite o novo autor desejado:");
                string_alteracao = sc.nextLine();
                sqlColuna = "autor";
                break;
            case 3:
                System.out.print("Digite a nova editora desejada:");
                string_alteracao = sc.nextLine();
                sqlColuna = "editora";
                break;
            case 4:
                System.out.print("Digite o novo ano desejado:");
                int_alteracao = sc.nextInt();
                sqlColuna = "ano";
                break;
            case 5:
                System.out.print("Digite a nova edição desejada:");
                int_alteracao = sc.nextInt();
                sqlColuna = "edicao";
                break;
            default:
                return;


        }


        String sql = "update livros set " + sqlColuna + "= ? where ISBN = " +  id_alteracao.toString();
        try {

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);

            if(acao == 4 || acao == 5) p.setInt(1, int_alteracao);
            else p.setString(1,string_alteracao);

            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


    }








}
