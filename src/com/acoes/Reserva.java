package com.acoes;

import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Reserva {

    public static void realizarReserva(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer ISBN = 0, user_id = 0, reserva_id=0;
        Boolean existemLivrosDisponiveis = true;

        //pegar isbn e user_id

        System.out.print("Insira o ISBN desejado para a reserva: ");
        ISBN = sc.nextInt(); sc.nextLine();

        System.out.print("Insira o ID do usuarioque realiza a reserva: ");
        user_id = sc.nextInt(); sc.nextLine();


        if(Auxilio.verificaSeTemMulta(conexaoSQLite,user_id)){
            System.out.println("Não é possível realizar uma reserva para um usuário com multa, pague sua conta antes de realizar uma reserva.");
            return;
        }


        //verificar se todos os exemplares estao locados

        String sql1 = "select * from livros WHERE ISBN = " + ISBN.toString();
        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            if(rs.getInt("disponiveis") != 0){
                System.out.println("Ainda existem exemplares disponiveis, não é possivel reservar.");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();



        //possivelrenovar=0 (emprestimos)
        String sql = "UPDATE emprestimos SET possivelRenovar = false WHERE ISBN = " + ISBN.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


        //reservado=1 (livros)
        sql = "UPDATE livros SET reservado = true WHERE ISBN = " + ISBN.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        //criar reserva no BD

        conexaoSQLite.conectar();
        sql = "INSERT INTO reservas(ISBN,user_id, reservaAtiva) VALUES (?,?,?);";


        try{

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);

            p.setInt(1,ISBN);
            p.setInt(2,user_id);
            p.setBoolean(3,true);
            p.execute();

            conexaoSQLite.desconectar();
        }catch(SQLException e){
            System.out.println("Erro");
        }


        conexaoSQLite.desconectar();

        sql = "select * from reservas WHERE ISBN = " + ISBN.toString() + " AND user_id = " + user_id;
        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            reserva_id = rs.getInt("reserva_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        System.out.println("Seu ID de reserva é: " + reserva_id + " anote esse valor para realizar outras operações");




    }

    public static void cancelarReserva(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer reserva_id = 0, user_id = 0, ISBN=0;
        Boolean existemLivrosDisponiveis = true;

        //pegar isbn

        System.out.print("Insira o ID da reserva a cancelar: ");
        reserva_id = sc.nextInt(); sc.nextLine();

        //verificar se reserva esta ativa

        String sql1 = "select * from reservas WHERE reserva_id = " + reserva_id.toString();
        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            ISBN = rs.getInt("ISBN");
            if(!rs.getBoolean("reservaAtiva")){
                System.out.println("A reserva já está inativa");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        //Desativar Reserva
        String sql = "UPDATE reservas SET reservaAtiva = false WHERE reserva_id = " + reserva_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


        //verifica se ainda existem outras reservas ativas do mesmo ISBN


        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM reservas");

            while(rs.next()){
                if((rs.getBoolean("reservaAtiva") ) && rs.getInt("ISBN")==ISBN) return;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();



        //possivelrenovar=1 (emprestimos)

        sql = "UPDATE emprestimos SET possivelRenovar = true WHERE ISBN = " + ISBN.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


        //reservado=0 (livros)
        sql = "UPDATE livros SET reservado = false WHERE ISBN = " + ISBN.toString();

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
