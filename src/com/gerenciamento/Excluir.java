package com.gerenciamento;

import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;
import com.principal.Exemplar;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Excluir {



    public static void excluirUsuario(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer idExcluir = 0;

        System.out.println("Digite o id do usuario que deseja excluir (-1 para voltar): ");
        idExcluir = sc.nextInt();

        if(idExcluir==-1) return;

        String sql = "DELETE FROM usuarios WHERE user_id = ?";

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);

            ps.setInt(1,idExcluir);
            ps.execute();

            System.out.println("Usuario excluido com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        conexaoSQLite.desconectar();




    }



    public static void excluirLivro(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer ISBNExcluir = 0;

        System.out.println("Digite o ISBN do livro que deseja excluir (-1 para voltar): ");
        ISBNExcluir = sc.nextInt();

        if(ISBNExcluir==-1) return;

        String sql = "DELETE FROM livros WHERE ISBN = ?";

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);

            ps.setInt(1,ISBNExcluir);
            ps.execute();

            System.out.println("Livro excluido com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        conexaoSQLite.desconectar();




    }



    public static void excluirExemplar(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer id_exclusao = 0;
        Integer ISBN;
        String temp = "";

        System.out.println("Digite o id do exemplar que deseja excluir: ");
        id_exclusao = sc.nextInt();

        ISBN = Auxilio.retornaISBN_exemplar(conexaoSQLite,id_exclusao);
        if(ISBN==-1) return;

        conexaoSQLite.conectar();
        String sql = "DELETE FROM exemplares WHERE exemplar_id = " + id_exclusao.toString() + ";";


        try{

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);
            p.execute();

            conexaoSQLite.desconectar();
        }catch(SQLException e){
            System.out.println("Erro");
        }


        conexaoSQLite.desconectar();
        conexaoSQLite.conectar();


        String sql1 = "update livros set exemplares = exemplares - 1, disponiveis = disponiveis - 1 where ISBN = " +  ISBN.toString();
        try {

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql1);
            p.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();




    }




}
