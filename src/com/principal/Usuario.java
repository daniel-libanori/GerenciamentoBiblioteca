package com.principal;

import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;

import java.util.Scanner;

public class Usuario {

    private int user_id;
    private String nome;
    private int emprestimosMax;
    private int emprestimosAtuais;
    private int multa;


    public Usuario() {
        Auxilio.LimpaTela();
        Scanner s = new Scanner(System.in);
        int aux;

        System.out.print("Insira o nome do usuário: ");
        this.nome = s.nextLine();
        System.out.print("O usuário é um aluno ou professor ? (0 - Aluno / 1 - Professor) ");
        aux =  s.nextInt();

        if (aux == 1) this.emprestimosMax = 5;
        else this.emprestimosMax = 3;
        this.emprestimosAtuais = 0;
        this.multa = 0;



    }

    public int getUser_id() {
        return user_id;
    }

    public String getNome() {
        return nome;
    }

    public int getEmprestimosMax() {
        return emprestimosMax;
    }

    public int getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public int getMulta() {
        return multa;
    }
}
