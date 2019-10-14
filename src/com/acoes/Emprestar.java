package com.acoes;

import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;
import com.principal.Emprestimo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Emprestar {


    public static void realizarEmprestimo(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);

        String temp = "";

        Emprestimo emp = new Emprestimo(conexaoSQLite);

        separarExemplarETrocarDisponibilidade(conexaoSQLite,emp.getISBN(),emp);


        conexaoSQLite.conectar();
        String sql = "INSERT INTO emprestimos(devolvido,possivelRenovar,exemplar_id,user_id,diaEmprestimo,mesEmprestimo,anoEmprestimo,diaDevolucao,mesDevolucao,anoDevolucao, ISBN) VALUES (?,?,?,?,?,?,?,?,?,?,?);";


        try{

            PreparedStatement p = conexaoSQLite.getConexao().prepareStatement(sql);

            p.setBoolean(1,emp.isDevolvido());
            p.setBoolean(2, emp.isPossivelRenovar());
            p.setInt(3,emp.getExemplar_id());
            p.setInt(4,emp.getUser_id());
            p.setInt(5,emp.getDiaEmprestimo());
            p.setInt(6,emp.getMesEmprestimo());
            p.setInt(7,emp.getAnoEmprestimo());
            p.setInt(8,emp.getDiaDevolucao());
            p.setInt(9,emp.getMesDevolucao());
            p.setInt(10,emp.getAnoDevolucao());
            p.setInt(11,emp.getISBN());
            p.execute();

            conexaoSQLite.desconectar();
        }catch(SQLException e){
            System.out.println("Erro");
        }


        conexaoSQLite.desconectar();

        Emprestar.adicionaEmprestimosUsuario(conexaoSQLite,emp.getUser_id());

    }

    private static void separarExemplarETrocarDisponibilidade(ConexaoSQLite conexaoSQLite, Integer ISBN_busca, Emprestimo emp){

        Scanner sc = new Scanner(System.in);
        String temp = "";
        String sql = "select * from exemplares WHERE ISBN = " + ISBN_busca.toString() + " AND disponivel = 1";

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            emp.setExemplar_id(rs.getInt("exemplar_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


        sql = "UPDATE exemplares SET disponivel = false WHERE exemplar_id = " + emp.getExemplar_id().toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        sql = "UPDATE livros SET disponiveis = disponiveis - 1 WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();











    }

    private static void adicionaEmprestimosUsuario(ConexaoSQLite conexaoSQLite, Integer user_id){

        String sql = "UPDATE usuarios SET emprestimosAtuais = emprestimosAtuais + 1 WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();



    }




    public static void renovarEmprestimo(ConexaoSQLite conexaoSQLite){

        Integer emprestimo_id;
        Integer user_id=0;
        Scanner sc = new Scanner(System.in);
        Boolean possivelRenovar=false;
        Integer dia,mes,ano;
        Integer diaRenov,mesRenov,anoRenov;


        System.out.print ("Digite o ID do emprestimo que deseja renovar: ");
        emprestimo_id = sc.nextInt(); sc.nextLine();

        String sql1 = "select * from emprestimos WHERE emprestimo_id = " + emprestimo_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            possivelRenovar= rs.getBoolean("possivelRenovar");
            user_id = rs.getInt("user_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        if(!possivelRenovar) {
            System.out.println("Livro está reservado, não é possivel renová-lo.");
            return;
        }

        System.out.print("Digite o dia da renovação: ");
        dia = sc.nextInt(); sc.nextLine();
        System.out.print("Digite o mes da renovação: ");
        mes = sc.nextInt(); sc.nextLine();
        System.out.print("Digite o ano da renovação: ");
        ano = sc.nextInt(); sc.nextLine();




        Boolean professor = Auxilio.verificaSeUsuarioEhProfessor(conexaoSQLite,user_id);
        int acrescimo;

        if (professor) acrescimo = 15;
        else acrescimo = 7;

        if(dia<= 30 - acrescimo) {
            diaRenov = dia + acrescimo;
            mesRenov = mes;
            anoRenov = ano;
        }
        else if(dia> 30 - acrescimo && mes<12) {
            diaRenov = dia + acrescimo -30;
            mesRenov = mes +1;
            anoRenov = ano;
        }
        else {
            diaRenov = dia + acrescimo - 30;
            mesRenov = mes +1 - 12;
            anoRenov = ano +1;
        }




        String sql = "UPDATE emprestimos SET diaDevolucao = " + diaRenov + ", mesDevolucao = " + mesRenov + ", anoDevolucao = " + anoRenov + " WHERE emprestimo_id = " + emprestimo_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


    }



    public static void devolverLivro(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        int emprestimo_id = 0, exemplar_id=0;
        int dia,mes,ano;
        String temp = "";

        System.out.print ("Digite o ID do emprestimo que deseja devolver: ");
        emprestimo_id = sc.nextInt(); sc.nextLine();

        //Marcar Emprestimo como devolvido OK
        //marcar exemplar como disponivel\
        //Aumentar unidade disponivel no livro

        emprestimoDevolvido(conexaoSQLite,emprestimo_id);
        exemplar_id = exemplarDevolvido(conexaoSQLite,emprestimo_id);
        livroDevolvido(conexaoSQLite, exemplar_id);

        System.out.print("Digite o dia da devolução: ");
        dia = sc.nextInt(); sc.nextLine();
        System.out.print("Digite o mes da devolução: ");
        mes = sc.nextInt(); sc.nextLine();
        System.out.print("Digite o ano da devolução: ");
        ano = sc.nextInt(); sc.nextLine();



        //Voltar Emprestimos atuais do Usuario

        usuarioAtualizaDevolucao(conexaoSQLite, emprestimo_id,dia,mes,ano);


    }

    private static void emprestimoDevolvido(ConexaoSQLite conexaoSQLite, Integer emprestimo_id){

        Scanner sc = new Scanner(System.in);
        String temp = "";


        String sql = "UPDATE emprestimos SET devolvido = true WHERE emprestimo_id = " + emprestimo_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

    }

    private static Integer exemplarDevolvido(ConexaoSQLite conexaoSQLite,Integer emprestimo_id){

        Integer exemplar_id = 0;

        String sql1 = "select * from emprestimos WHERE emprestimo_id = " + emprestimo_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            exemplar_id = rs.getInt("exemplar_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


        String sql = "UPDATE exemplares SET disponivel = true WHERE exemplar_id = " + exemplar_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        return exemplar_id;

    }

    private static void livroDevolvido(ConexaoSQLite conexaoSQLite, Integer exemplar_id){

        Integer ISBN = 0;

        String sql1 = "select * from exemplares WHERE exemplar_id = " + exemplar_id.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            ISBN = rs.getInt("ISBN");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


        String sql = "UPDATE livros SET disponiveis = disponiveis + 1 WHERE ISBN = " + ISBN.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();





    }

    private static void usuarioAtualizaDevolucao(ConexaoSQLite conexaoSQLite, Integer emprestimo_id, Integer dia, Integer mes, Integer ano){


        Integer user_id = 0;
        Integer diaDevolucao=0, mesDevolucao=0, anoDevolucao=0, multa=0;
        String sql1 = "select * from emprestimos WHERE emprestimo_id = " + emprestimo_id.toString();


        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            user_id = rs.getInt("user_id");
            diaDevolucao = rs.getInt("diaDevolucao");
            mesDevolucao = rs.getInt("mesDevolucao");
            anoDevolucao = rs.getInt("anoDevolucao");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();

        multa = calculoMulta(diaDevolucao,mesDevolucao,anoDevolucao,dia,mes,ano);

        String sql = "UPDATE usuarios SET emprestimosAtuais = emprestimosAtuais - 1, multa = multa + " + multa.toString() + " WHERE user_id = " + user_id.toString();

        conexaoSQLite.conectar();

        try {
            PreparedStatement ps = conexaoSQLite.getConexao().prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conexaoSQLite.desconectar();


    }

    private static Integer calculoMulta(int diaDevolucao, int mesDevolucao, int anoDevolucao, int diaDevolvido, int mesDevolvido, int anoDevolvido){

        int devolucaoTotal=0;
        int devolvidoTotal=0;
        int multa=0;

        devolucaoTotal = diaDevolucao + mesDevolucao*30 + anoDevolucao*365;
        devolvidoTotal = diaDevolvido + mesDevolvido*30 + anoDevolvido*365;

        multa = devolvidoTotal - devolucaoTotal;
        if(multa<0)multa=0;

        return multa;

    }






}