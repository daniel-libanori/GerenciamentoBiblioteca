package com.principal;


import com.auxiliar.Auxilio;
import com.banco_de_dados.ConexaoSQLite;

import java.util.Scanner;

public class Emprestimo {

    private int emprestimo_id;
    private boolean devolvido;
    private boolean possivelRenovar;
    private int exemplar_id;
    private int user_id;
    private int diaEmprestimo;
    private int mesEmprestimo;
    private int anoEmprestimo;
    private int diaDevolucao;
    private int mesDevolucao;
    private int anoDevolucao;
    private int ISBN;
    private String nomeLivro;

    public Emprestimo(ConexaoSQLite conexaoSQLite){

        Scanner sc = new Scanner(System.in);
        this.devolvido = false;
        this.possivelRenovar = true;


        System.out.print("Digite o id do usuário que vai realizar o emprestimo: ");
        this.user_id = sc.nextInt(); sc.nextLine();

        if(!Auxilio.verificaSeUsuarioExiste(conexaoSQLite,this.user_id)) return;
        if(Auxilio.verificaSeUsuarioPodeFazerMaisEmprestimos(conexaoSQLite,this.user_id)){
            System.out.println("Número máximo de emprestimos atingido");
            return;
        }


        System.out.print("Digite o ISBN do livro que deseja emprestar: ");
        this.ISBN = sc.nextInt(); sc.nextLine();


        if(!Auxilio.verificaSeLivroExiste(conexaoSQLite,this.ISBN)) return;
        if(!Auxilio.verificaSeLivroEstaDisponivel(conexaoSQLite,this.ISBN)) return;


        System.out.print("Digite o dia do emprestimo: ");
        this.diaEmprestimo = sc.nextInt(); sc.nextLine();
        System.out.print("Digite o mes do emprestimo: ");
        this.mesEmprestimo = sc.nextInt(); sc.nextLine();
        System.out.print("Digite o ano do emprestimo: ");
        this.anoEmprestimo = sc.nextInt(); sc.nextLine();


        this.calculaDevolucao(this.diaEmprestimo,this.mesEmprestimo,this.anoEmprestimo, Auxilio.verificaSeUsuarioEhProfessor(conexaoSQLite,this.user_id));



    }

    private void calculaDevolucao(int dia, int mes, int ano, boolean professor){

        int acrescimo;

        if (professor)acrescimo = 15;
        else acrescimo = 7;


            if(dia<= 30 - acrescimo) {
                this.setDiaDevolucao(dia + acrescimo);
                this.setMesDevolucao(mes);
                this.setAnoDevolucao(ano);
            }
            else if(dia> 30 - acrescimo && mes<12) {
                this.setDiaDevolucao(dia + acrescimo - 30);
                this.setMesDevolucao(mes + 1);
                this.setAnoDevolucao(ano);
            }
            else {
                this.setDiaDevolucao(dia + acrescimo - 30);
                this.setMesDevolucao(mes + 1 - 12);
                this.setAnoDevolucao(ano + 1);
            }


    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getEmprestimo_id() {
        return emprestimo_id;
    }

    public void setEmprestimo_id(int emprestimo_id) {
        this.emprestimo_id = emprestimo_id;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public boolean isPossivelRenovar() {
        return possivelRenovar;
    }

    public void setPossivelRenovar(boolean possivelRenovar) {
        this.possivelRenovar = possivelRenovar;
    }

    public Integer getExemplar_id() {
        return exemplar_id;
    }

    public void setExemplar_id(int exemplar_id) {
        this.exemplar_id = exemplar_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDiaEmprestimo() {
        return diaEmprestimo;
    }

    public void setDiaEmprestimo(int diaEmprestimo) {
        this.diaEmprestimo = diaEmprestimo;
    }

    public int getMesEmprestimo() {
        return mesEmprestimo;
    }

    public void setMesEmprestimo(int mesEmprestimo) {
        this.mesEmprestimo = mesEmprestimo;
    }

    public int getAnoEmprestimo() {
        return anoEmprestimo;
    }

    public void setAnoEmprestimo(int anoEmprestimo) {
        this.anoEmprestimo = anoEmprestimo;
    }

    public int getDiaDevolucao() {
        return diaDevolucao;
    }

    public void setDiaDevolucao(int diaDevolucao) {
        this.diaDevolucao = diaDevolucao;
    }

    public int getMesDevolucao() {
        return mesDevolucao;
    }

    public void setMesDevolucao(int mesDevolucao) {
        this.mesDevolucao = mesDevolucao;
    }

    public int getAnoDevolucao() {
        return anoDevolucao;
    }

    public void setAnoDevolucao(int anoDevolucao) {
        this.anoDevolucao = anoDevolucao;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
}
