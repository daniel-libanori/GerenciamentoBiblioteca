package com.gerenciamento;

import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;
import com.principal.Exemplar;
import com.principal.Livro;
import com.principal.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserir {

    public static void inserirUsuario(ConexaoSQLite conexaoSQLite){

        String sql = "INSERT INTO usuarios(nome, maximoEmprestimos, emprestimosAtuais, multa) VALUES (?,?,?,?);";

        Usuario u = new Usuario();

        conexaoSQLite.conectar();

        try{
        PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);


        p.setString(1,u.getNome());
        p.setInt(2,u.getEmprestimosMax());
        p.setInt(3,u.getEmprestimosAtuais());
        p.setInt(4, u.getMulta());

        p.execute();

        conexaoSQLite.desconectar();
        }catch(SQLException e){
            System.out.println("Erro");
        }


    }

    public static void inserirLivro(ConexaoSQLite conexaoSQLite){

        String sql = "INSERT INTO livros(ISBN, nome, autor, editora, ano, edicao, exemplares, disponiveis, reservado) VALUES (?,?,?,?,?,?,?,?,?);";

        Livro l = new Livro();
        conexaoSQLite.conectar();

        try{

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);



            p.setInt(1,l.getISBN());
            p.setString(2,l.getNome());
            p.setString(3,l.getAutor());
            p.setString(4,l.getEditora());

            p.setInt(5,l.getAno());
            p.setInt(6, l.getEdicao());
            p.setInt(7,l.getExemplares());
            p.setInt(8, l.getDisponiveis());
            p.setBoolean(9, l.isReservado());

            p.execute();




            conexaoSQLite.desconectar();
        }catch(SQLException e){
            System.out.println("Erro");
        }


    }



    public static void inserirExemplar(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);

        String temp = "";

        Exemplar exe = new Exemplar();

        if(!Auxilio.verificaSeLivroExiste(conexaoSQLite,exe.getISBN())) return;



        conexaoSQLite.conectar();
        String sql = "INSERT INTO exemplares(ISBN,disponivel) VALUES (?,?);";


        try{

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);

            p.setInt(1,exe.getISBN());
            p.setBoolean(2,exe.isDisponivel());
            p.execute();

            conexaoSQLite.desconectar();
        }catch(SQLException e){
            System.out.println("Erro");
        }


        conexaoSQLite.desconectar();
        conexaoSQLite.conectar();


        String sql1 = "update livros set exemplares = exemplares + 1, disponiveis = disponiveis + 1 where ISBN = " +  exe.getISBN().toString();
        try {

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql1);
            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

    }





}
