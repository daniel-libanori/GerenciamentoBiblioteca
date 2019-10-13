package com.banco_de_dados;

import java.sql.SQLException;
import java.sql.Statement;
import com.banco_de_dados.ConexaoSQLite;


public class CriarTabelas {

    private ConexaoSQLite conexaoSQLite;

    public CriarTabelas(ConexaoSQLite p){
        conexaoSQLite = p;
    }

    public void criarTabelas(){
        criarTabelaUsuarios();
        criarTabelaLivros();
        criarTabelaExemplares();
        criarTabelaEmprestimos();
        criarTabelaRevervas();
    }


    private void criarTabelaUsuarios(){
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (user_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, nome STRING  NOT NULL, maximoEmprestimos INTEGER NOT NULL, emprestimosAtuais INTEGER,multa INTEGER);" ;

        boolean conectou = false;

        try{
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(conectou)
                this.conexaoSQLite.desconectar();
        }

    }
    private void criarTabelaLivros(){
        String sql = "CREATE TABLE IF NOT EXISTS  livros (" +
                "    ISBN        INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                "    nome        STRING  NOT NULL," +
                "    autor       STRING  NOT NULL," +
                "    editora     STRING  NOT NULL," +
                "    ano         INTEGER NOT NULL," +
                "    edicao      INTEGER NOT NULL," +
                "    exemplares  INTEGER," +
                "    disponiveis INTEGER," +
                "    reservado   BOOLEAN" +
                ");" ;

        boolean conectou = false;

        try{
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(conectou)
                this.conexaoSQLite.desconectar();
        }

    }
    private void criarTabelaExemplares(){
        String sql = "CREATE TABLE IF NOT EXISTS  exemplares ("
                + "exemplar_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL,"
                + "ISBN        INTEGER REFERENCES livros (ISBN)  NOT NULL,"
                + "disponivel  BOOLEAN"
                + ");";

        boolean conectou = false;

        try{
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(conectou)
                this.conexaoSQLite.desconectar();
        }

    }
    private void criarTabelaEmprestimos(){
        String sql = "CREATE TABLE IF NOT EXISTS  emprestimos (\n" +
                "    emprestimo_id   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "    dataEmprestimo  DATE    NOT NULL," +
                "    dataDevolucao   DATE    NOT NULL," +
                "    devolvido       BOOLEAN NOT NULL," +
                "    possivelRenovar BOOLEAN NOT NULL," +
                "    exemplar_id     INTEGER REFERENCES exemplares," +
                "    user_id         INTEGER REFERENCES usuarios (user_id)" +
                ");";

        boolean conectou = false;

        try{
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(conectou)
                this.conexaoSQLite.desconectar();
        }

    }
    private void criarTabelaRevervas(){
        String sql = "CREATE TABLE IF NOT EXISTS  reservas (" +
                     "reverva_id INTEGER PRIMARY KEY AUTOINCREMENT    NOT NULL UNIQUE," +
                     "ISBN       INTEGER REFERENCES livros (ISBN)     NOT NULL," +
                     "user_id    INTEGER REFERENCES usuarios (user_id) NOT NULL" +
                     ");";

        boolean conectou = false;

        try{
            conectou = this.conexaoSQLite.conectar();

            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql);

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }finally {
            if(conectou)
                this.conexaoSQLite.desconectar();
        }

    }


}
