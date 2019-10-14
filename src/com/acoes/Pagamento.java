package com.acoes;

import com.banco_de_dados.ConexaoSQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Pagamento {

    public static void pagarMulta(ConexaoSQLite conexaoSQLite){

        Integer user_id = 0;
        Integer diaDevolucao=0, mesDevolucao=0, anoDevolucao=0, multa=0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o id do usuário que deseja pagar a multa: ");
        user_id = sc.nextInt(); sc.nextLine();


        String sql1 = "select * from usuarios WHERE user_id = " + user_id.toString();
        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            multa = rs.getInt("multa");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        String sql = "UPDATE usuarios SET multa = 0 WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

    }



}
