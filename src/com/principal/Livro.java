package com.principal;

import com.auxiliar.Auxilio;

import java.util.Scanner;

public class Livro {

    private int ISBN;
    private String nome;
    private String autor;
    private String editora;
    private int ano;
    private int edicao;
    private int exemplares;
    private int disponiveis;
    private boolean reservado;

    public Livro(){

        Auxilio.LimpaTela();
        Scanner s = new Scanner(System.in);
        int aux;

        System.out.print("Insira o ISBN do livro: ");
        this.ISBN = s.nextInt(); s.nextLine();
        System.out.print("Insira o nome do livro: ");
        this.nome = s.nextLine();
        System.out.print("Insira o nome do autor: ");
        this.autor = s.nextLine();

        System.out.print("Insira o nome da editora: ");
        this.editora = s.nextLine();
        System.out.print("Insira o ano do livro: ");
        this.ano = s.nextInt();
        System.out.print("Insira a ediçào do livro: ");
        this.edicao = s.nextInt();

        this.exemplares=0;
        this.disponiveis=0;
        this.reservado = false;

    }


    public int getISBN() {
        return ISBN;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getExemplares() {
        return exemplares;
    }

    public int getDisponiveis() {
        return disponiveis;
    }

    public boolean isReservado() {
        return reservado;
    }
}
