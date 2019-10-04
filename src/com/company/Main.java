package com.company;

import com.banco_de_dados.ConexaoBanco;

import java.sql.*;

public class Main {

    public static void main(String[] args)  throws ClassNotFoundException, SQLException {

        ConexaoBanco conexao = new ConexaoBanco();
        Class.forName("com.company.mysql-connector-java-8.0.17");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/paradigmas", "root", "746PARDAL12canario");

        Statement s = c.createStatement();
        System.out.println("Listando Usuários");

        ResultSet rs = s.executeQuery("select * from usuario");
        while(rs.next())
            System.out.println(rs.getString("nome") + "-" + rs.getInt("multa"));





    }
}
