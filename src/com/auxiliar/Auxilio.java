package com.auxiliar;

import com.banco_de_dados.ConexaoSQLite;
import com.principal.Livro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Auxilio {

    public final static void LimpaTela(){

        for(int i=0;i<150;i++){
            System.out.println("\n");
        }

    }

    public static boolean verificaSeLivroExiste(ConexaoSQLite conexaoSQLite, int ISBN){

        Integer ISBN_busca = ISBN;


        String sql1 = "SELECT * FROM livros WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            if(!rs.next()){
                System.out.println("ISBN do livro digitado não consta nos livros cadastrados, cadastre o livro antes fde cadastrar mais um exemplar.");
                conexaoSQLite.desconectar();
                return false;
            }else {


                conexaoSQLite.desconectar();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return false;
    }

    public static boolean verificaSeLivroEstaDisponivel(ConexaoSQLite conexaoSQLite, int ISBN){

        Integer ISBN_busca = ISBN;


        String sql1 = "SELECT * FROM livros WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            if (rs.getInt("disponiveis")>0){
                conexaoSQLite.desconectar();
                return true;
            } else {
                conexaoSQLite.desconectar();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return false;
    }



    public static boolean verificaSeUsuarioExiste(ConexaoSQLite conexaoSQLite, Integer user_id){


        String sql1 = "SELECT * FROM usuarios WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            if(!rs.next()){
                System.out.println("Usuario nao encontrado no sistema");
                conexaoSQLite.desconectar();
                return false;
            }else {
                    conexaoSQLite.desconectar();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return false;
    }

    public static boolean verificaSeUsuarioEhProfessor(ConexaoSQLite conexaoSQLite, Integer user_id){


        String sql1 = "SELECT * FROM usuarios WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            if(rs.getInt("maximoEmprestimos")==5){
                conexaoSQLite.desconectar();
                return true;
            }else {
                conexaoSQLite.desconectar();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return false;
    }

    public static boolean verificaSeUsuarioPodeFazerMaisEmprestimos(ConexaoSQLite conexaoSQLite, Integer user_id){


        String sql1 = "SELECT * FROM usuarios WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            if(rs.getInt("emprestimosAtuais")==rs.getInt("maximoEmprestimos")){
                conexaoSQLite.desconectar();
                return true;
            }else {
                conexaoSQLite.desconectar();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return false;
    }

    public static int retornaISBN_exemplar(ConexaoSQLite conexaoSQLite, Integer exemplar_id){

        String temp = "";
        int tempInt = 0;
        String sql = "SELECT * FROM exemplares WHERE exemplar_id = " + exemplar_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                tempInt = rs.getInt("ISBN");
                conexaoSQLite.desconectar();
                return tempInt;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return -1;
    }

    public static Boolean verificaSeTemMulta(ConexaoSQLite conexaoSQLite, Integer user_id){

        String sql1 = "SELECT * FROM usuarios WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            if(rs.getInt("multa")!=0){
                conexaoSQLite.desconectar();
                return true;
            }else {
                conexaoSQLite.desconectar();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return false;





    }

    public static Integer verificaEmprestimosAtuais(ConexaoSQLite conexaoSQLite, Integer user_id){

        String sql1 = "SELECT * FROM usuarios WHERE user_id = " + user_id.toString();
        int emprestimosAtuais = 0;


        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            emprestimosAtuais = rs.getInt("emprestimosAtuais");
            conexaoSQLite.desconectar();
            return emprestimosAtuais;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return emprestimosAtuais;





    }

    public static String retornaNomeLivro_ISBN(ConexaoSQLite conexaoSQLite, Integer ISBN){

        String sql1 = "SELECT * FROM livros WHERE ISBN = " + ISBN.toString();
        String nomeLivro = "";


        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            nomeLivro = rs.getString("nome");
            conexaoSQLite.desconectar();
            return nomeLivro;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();
        return nomeLivro;

    }


}
