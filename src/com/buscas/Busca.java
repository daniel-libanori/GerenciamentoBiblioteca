package com.buscas;

import com.banco_de_dados.ConexaoSQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Busca {

    public static void buscar_usuarioID(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer id_busca;
        String temp = "";

        System.out.println("Digite o ID do usuário buscado: ");
        id_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM usuarios WHERE user_id = " + id_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                if(rs.getInt("maximoEmprestimos")==5) temp = "Professor";
                else temp = "Aluno";
                System.out.println(rs.getInt("user_id") + " - " + rs.getString("nome") + " - " + temp + " - " + rs.getInt("emprestimosAtuais") + " - R$" + rs.getInt("multa") + ",00");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        conexaoSQLite.desconectar();

    }


    public static void buscar_livroISBN(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer ISBN_busca;
        String temp = "";

        System.out.println("Digite o ISBN do livro buscado: ");
        ISBN_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM livros WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                if(rs.getBoolean("reservado")) temp = "Reservado";
                else temp = "Disponivel";
                System.out.println(rs.getInt("ISBN") + " - " + rs.getString("nome") + " - " + rs.getString("autor") + " - " + rs.getString("editora") + " - " + rs.getInt("ano") + " - " + rs.getInt("edicao") + " - " + temp  + " - Exemplares: " + rs.getInt("disponiveis"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();

    }


    public static void buscar_exemplarID(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer id_busca;
        String temp = "";

        System.out.println("Digite o ID do exemplar buscado: ");
        id_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM exemplares WHERE exemplar_id = " + id_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ExemplarID  \t  ISBN  \t  Disponivel");

            while(rs.next()){
                if(rs.getBoolean("disponivel")) temp = "Sim";
                else temp = "Não";
                System.out.println("  " + rs.getInt("exemplar_id") + "\t\t\t\t" + rs.getString("ISBN") + "\t\t\t\t" + temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();

    }


    public static void buscar_exemplarISBN(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer ISBN_busca;
        String temp = "";

        System.out.println("Digite o ISBN do exemplar buscado: ");
        ISBN_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM exemplares WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ExemplarID  \t  ISBN  \t  Disponivel");

            while(rs.next()){
                if(rs.getBoolean("disponivel")) temp = "Sim";
                else temp = "Não";
                System.out.println("  " + rs.getInt("exemplar_id") + "\t\t\t\t" + rs.getString("ISBN") + "\t\t\t\t" + temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();

    }





}
