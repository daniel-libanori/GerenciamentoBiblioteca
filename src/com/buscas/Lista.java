package com.buscas;

import com.banco_de_dados.ConexaoSQLite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Lista {

    public static void usuario_listarTodos(ConexaoSQLite conexaoSQLite){

        String temp;

        conexaoSQLite.conectar();

        Statement s = conexaoSQLite.criarStatement();

        System.out.println("Listando todos os usuários: ");

        try {
            ResultSet rs = s.executeQuery("select * FROM usuarios");

            while(rs.next()){
                if(rs.getInt("maximoEmprestimos")==5) temp = "Professor";
                else temp = "Aluno";
                System.out.println(rs.getInt("user_id") + " - " + rs.getString("nome") + " - " + temp  + " - Emprestimos Atuais: " + rs.getInt("emprestimosAtuais") + " - Multa: R$" + rs.getInt("multa") + ",00");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void livro_listarTodos(ConexaoSQLite conexaoSQLite){

        String temp;

        conexaoSQLite.conectar();

        Statement s = conexaoSQLite.criarStatement();

        System.out.println("Listando todos os livros: ");

        try {
            ResultSet rs = s.executeQuery("select * FROM livros");

            while(rs.next()){
                if(rs.getBoolean("reservado")) temp = "Reservado";
                else temp = "Disponivel";
                System.out.println(rs.getInt("ISBN") + " - " + rs.getString("nome") + " - " + rs.getString("autor") + " - " + rs.getString("editora") + " - " + rs.getInt("ano") + " - " + rs.getInt("edicao") + " - " + temp  + " - Exemplares: " + rs.getInt("disponiveis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void emprestimos_listaTodos(ConexaoSQLite conexaoSQLite){

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        System.out.println("Listando todos os emprestimos em aberto: ");

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos");

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                        rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                        rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }


    public static void emprestimos_listaPorUsuario(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);
        Integer user_id;

        System.out.print("Digite o Id do usuario que deseja buscar: ");
        user_id = sc.nextInt(); sc.nextLine();

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos WHERE user_id = " + user_id.toString());

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    public static void emprestimos_listaPorISBN(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);
        Integer ISBN;

        System.out.print("Digite o ISBN do Livro que deseja buscar: ");
        ISBN = sc.nextInt(); sc.nextLine();

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos WHERE ISBN = " + ISBN.toString());

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    public static void emprestimos_listaPorExemplar(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);
        Integer exemplar_id;

        System.out.print("Digite o Id do Exemplar que deseja buscar: ");
        exemplar_id = sc.nextInt(); sc.nextLine();

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos WHERE exemplar_id = " + exemplar_id.toString());

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

}
