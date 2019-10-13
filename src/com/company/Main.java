package com.company;


import com.banco_de_dados.ConexaoSQLite;
import com.banco_de_dados.CriarTabelas;
import com.operacoes.Inserir;
import com.principal.Usuario;

import java.sql.*;

public class Main {

    public static void main(String[] args)  throws ClassNotFoundException, SQLException {


        ConexaoSQLite conexaoSQlite = new ConexaoSQLite();
        CriarTabelas criar = new CriarTabelas(conexaoSQlite);
        criar.criarTabelas();


        //Inserir.inserirUsuario(conexaoSQlite);
        Inserir.inserirLivro(conexaoSQlite);


    }
}
