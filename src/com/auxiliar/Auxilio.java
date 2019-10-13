package com.auxiliar;

import com.banco_de_dados.ConexaoSQLite;
import com.principal.Livro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Auxilio {

    public final static void LimpaTela()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public static boolean verificaSeLivroExiste(ConexaoSQLite conexaoSQLite, int ISBN, boolean estouInserindoExemplar){

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
                if(estouInserindoExemplar)

                conexaoSQLite.desconectar();
                return true;
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




}
