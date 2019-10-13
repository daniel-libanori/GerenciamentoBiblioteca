package com.buscas;

import com.banco_de_dados.ConexaoSQLite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listagem {

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





}
