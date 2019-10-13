package com.company;


import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;
import com.banco_de_dados.CriarTabelas;
import com.buscas.Busca;
import com.buscas.Lista;
import com.gerenciamento.Excluir;
import com.gerenciamento.Inserir;

import java.sql.*;

public class Main {

    public static void main(String[] args)  throws ClassNotFoundException, SQLException {


        ConexaoSQLite conexaoSQlite = new ConexaoSQLite();
        CriarTabelas criar = new CriarTabelas(conexaoSQlite);
        criar.criarTabelas();


        //Inserir.inserirUsuario(conexaoSQlite);
        //Inserir.inserirLivro(conexaoSQlite);
        //Listagem.usuario_listarTodos(conexaoSQlite);
        //Alterar.alterarUsuario(conexaoSQlite);
        //Alterar.alterarLivro(conexaoSQlite);
        //Excluir.excluirUsuario(conexaoSQlite);
        //Excluir.excluirLivro(conexaoSQlite);
        //Lista.livro_listarTodos(conexaoSQlite);
        //Busca.buscar_UsuarioID(conexaoSQlite);
        //Busca.buscar_livroISBN(conexaoSQlite);
        //Inserir.inserirExemplar(conexaoSQlite);
        //Excluir.excluirExemplar(conexaoSQlite);
        //Busca.buscar_exemplarID(conexaoSQlite);
        Busca.buscar_exemplarISBN(conexaoSQlite);
    }
}
