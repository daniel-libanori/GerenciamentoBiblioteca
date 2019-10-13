package com.gerenciamento;

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







}
