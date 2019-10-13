package com.banco_de_dados;

import java.sql.*;

public class ConexaoSQLite {

    private Connection conexao;

    public boolean conectar(){

        try{
            String url = "jdbc:sqlite:database.db";
            this.conexao = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }

        return  true;
    }

    public boolean desconectar(){

        try{
            if(this.conexao.isClosed() == false)
                    this.conexao.close();
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public Statement criarStatement(){
        try{
            return this.conexao.createStatement();
        }catch(SQLException e){
            return null;
        }
    }

    public PreparedStatement criarPreparedStatement(String sql){
        try{
            return this.conexao.prepareStatement(sql);
        }catch(SQLException e){
            return null;
        }
    }


    public Connection getConexao(){
        return this.conexao;
    }




}
