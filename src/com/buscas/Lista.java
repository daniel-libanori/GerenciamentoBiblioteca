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



}
