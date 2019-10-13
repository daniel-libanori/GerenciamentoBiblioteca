package com.principal;

import java.util.Scanner;

public class Exemplar {

    private int exemplar_id;
    private int ISBN;
    private boolean disponivel;

    public Exemplar(){

        Scanner sc = new Scanner(System.in);
        this.disponivel = true;

        System.out.println("Digite o ISBN do livro que deseja incluir um novo exemplar: ");
        this.ISBN = sc.nextInt();

    }


    public int getExemplar_id() {
        return exemplar_id;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}
