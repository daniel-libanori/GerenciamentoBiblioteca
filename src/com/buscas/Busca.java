package com.buscas;

import com.banco_de_dados.ConexaoSQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Busca {

    public static void buscar_usuarioID(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer id_busca;
        String temp = "";

        System.out.println("Digite o ID do usuário buscado: ");
        id_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM usuarios WHERE user_id = " + id_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                if(rs.getInt("maximoEmprestimos")==5) temp = "Professor";
                else temp = "Aluno";
                System.out.println(rs.getInt("user_id") + " - " + rs.getString("nome") + " - " + temp + " - " + rs.getInt("emprestimosAtuais") + " - R$" + rs.getInt("multa") + ",00");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        conexaoSQLite.desconectar();

    }

    public static void buscar_livroISBN(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer ISBN_busca;
        String temp = "";

        System.out.println("Digite o ISBN do livro buscado: ");
        ISBN_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM livros WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                if(rs.getBoolean("reservado")) temp = "Reservado";
                else temp = "Disponivel";
                System.out.println(rs.getInt("ISBN") + " - " + rs.getString("nome") + " - " + rs.getString("autor") + " - " + rs.getString("editora") + " - " + rs.getInt("ano") + " - " + rs.getInt("edicao") + " - " + temp  + " - Exemplares: " + rs.getInt("disponiveis"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();

    }

    public static void buscar_exemplarID(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer id_busca;
        String temp = "";

        System.out.println("Digite o ID do exemplar buscado: ");
        id_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM exemplares WHERE exemplar_id = " + id_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ExemplarID  \t  ISBN  \t  Disponivel");

            while(rs.next()){
                if(rs.getBoolean("disponivel")) temp = "Sim";
                else temp = "Não";
                System.out.println("  " + rs.getInt("exemplar_id") + "\t\t\t\t" + rs.getString("ISBN") + "\t\t\t\t" + temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();

    }

    public static void buscar_exemplarISBN(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        Integer ISBN_busca;
        String temp = "";

        System.out.println("Digite o ISBN do exemplar buscado: ");
        ISBN_busca = sc.nextInt(); sc.nextLine();

        String sql = "SELECT * FROM exemplares WHERE ISBN = " + ISBN_busca.toString();

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ExemplarID  \t  ISBN  \t  Disponivel");

            while(rs.next()){
                if(rs.getBoolean("disponivel")) temp = "Sim";
                else temp = "Não";
                System.out.println("  " + rs.getInt("exemplar_id") + "\t\t\t\t" + rs.getString("ISBN") + "\t\t\t\t" + temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();

    }

    public static void buscar_livroNome(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        String nomeBusca;
        String temp = "";

        System.out.println("Digite o nome do livro buscado: ");
        nomeBusca = sc.nextLine();

        String sql = "SELECT * FROM livros WHERE nome LIKE '%" + nomeBusca + "%'";

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                if(rs.getBoolean("reservado")) temp = "Reservado";
                else temp = "Disponivel";
                System.out.println(rs.getInt("ISBN") + " - " + rs.getString("nome") + " - " + rs.getString("autor") + " - " + rs.getString("editora") + " - " + rs.getInt("ano") + " - " + rs.getInt("edicao") + " - " + temp  + " - Exemplares: " + rs.getInt("disponiveis"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();
    }

    public static void buscar_livroEditora(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        String editoraBusca;
        String temp = "";

        System.out.println("Digite o nome da editora do livro buscado: ");
        editoraBusca = sc.nextLine();

        String sql = "SELECT * FROM livros WHERE nome LIKE '%" + editoraBusca + "%'";

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                if(rs.getBoolean("reservado")) temp = "Reservado";
                else temp = "Disponivel";
                System.out.println(rs.getInt("ISBN") + " - " + rs.getString("nome") + " - " + rs.getString("autor") + " - " + rs.getString("editora") + " - " + rs.getInt("ano") + " - " + rs.getInt("edicao") + " - " + temp  + " - Exemplares: " + rs.getInt("disponiveis"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();
    }

    public static void buscar_usuarioNome(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        String nomeBusca;
        String temp = "";

        System.out.println("Digite o nome do usuario buscado: ");
        nomeBusca = sc.nextLine();

        String sql = "SELECT * FROM usuarios WHERE nome LIKE '%" + nomeBusca + "%'";

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                if(rs.getInt("maximoEmprestimos")==5) temp = "Professor";
                else temp = "Aluno";
                System.out.println(rs.getInt("user_id") + " - " + rs.getString("nome") + " - " + temp + " - " + rs.getInt("emprestimosAtuais") + " - R$" + rs.getInt("multa") + ",00");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();
    }

    public static void emprestimos_buscaPorISBN(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);
        Integer ISBN;

        System.out.print("Digite o ISBN do Livro que deseja buscar: ");
        ISBN = sc.nextInt(); sc.nextLine();

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos WHERE ISBN = " + ISBN.toString());

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    public static void emprestimos_buscaPorExemplar(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);
        Integer exemplar_id;

        System.out.print("Digite o Id do Exemplar que deseja buscar: ");
        exemplar_id = sc.nextInt(); sc.nextLine();

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos WHERE exemplar_id = " + exemplar_id.toString());

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    public static void buscar_emprestimoNome(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        String nomeLivroBusca;
        String temp = "";

        System.out.println("Digite o nome do livro do emprestimo buscado: ");
        nomeLivroBusca = sc.nextLine();

        String sql = "SELECT * FROM emprestimos WHERE nomeLivro LIKE '%" + nomeLivroBusca + "%'";

        conexaoSQLite.conectar();

        try {
            Statement stmt = conexaoSQLite.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("User_id: " + rs.getInt("user_id") +" ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        conexaoSQLite.desconectar();
    }


    public static void buscar_emprestimosUsuario(ConexaoSQLite conexaoSQLite){


        Scanner sc = new Scanner(System.in);
        Integer user_id;

        System.out.print("Digite o Id do usuario que deseja buscar: ");
        user_id = sc.nextInt(); sc.nextLine();

        conexaoSQLite.conectar();
        Statement s = conexaoSQLite.criarStatement();

        try {
            ResultSet rs = s.executeQuery("select * FROM emprestimos WHERE user_id = " + user_id.toString());

            while(rs.next()){
                if(!rs.getBoolean("devolvido"))
                    System.out.println("ISBN: " + rs.getInt("ISBN") + " Emprestimo_id: " + rs.getInt("emprestimo_id") + " - " + "Exemplar_id: " + rs.getString("exemplar_id") + " - Emprestimo: " +
                            rs.getString("diaEmprestimo") + "/" + rs.getString("mesEmprestimo") + "/" + rs.getString("anoEmprestimo") + " - Devolução: " +
                            rs.getString("diaDevolucao") + "/" + rs.getString("mesDevolucao") + "/" + rs.getString("anoDevolucao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }


}
