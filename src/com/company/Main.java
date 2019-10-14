package com.company;


import com.acoes.Emprestar;
import com.acoes.Pagamento;
import com.acoes.Reserva;
import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;
import com.banco_de_dados.CriarTabelas;
import com.buscas.Busca;
import com.buscas.Lista;
import com.gerenciamento.Excluir;
import com.gerenciamento.Inserir;
import com.menu.Geral;
import com.principal.Emprestimo;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args)  throws ClassNotFoundException, SQLException {


        ConexaoSQLite conexaoSQlite = new ConexaoSQLite();

        CriarTabelas criar = new CriarTabelas(conexaoSQlite);
        criar.criarTabelas();


        Geral.menuGeral(conexaoSQlite);


    }
}
