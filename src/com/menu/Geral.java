package com.menu;

import java.util.Scanner;

public class Geral {

    public static void menuGeral(){
        int acaoMenu;
        Scanner ler = new Scanner(System.in);

        while(true) {

            System.out.println("Escolha a ação desejada: ");
            System.out.println("1 - Gerenciamento ");
            System.out.println("2 - Busca");
            System.out.println("3 - Ações");
            System.out.println(("0 - Sair"));

            acaoMenu = ler.nextInt();

            switch (acaoMenu){
                case 1:
                    System.out.println("Escolha a ação desejada: ");
                    System.out.println("  - Gerenciamento ");
                    System.out.println("\t1 - Livros");
                    System.out.println("\t2 - Usuários");
                    System.out.println("\t0 - Voltar");
                    System.out.println("  - Busca");
                    System.out.println("  - Ações");
                    System.out.println(("  - Sair"));
                    acaoMenu = ler.nextInt();
                    //if(acaoMenu>=2)this.gerenciamento(acaoMenu);

                case 2:
                    System.out.println("Escolha a ação desejada: ");
                    System.out.println("  - Gerenciamento ");
                    System.out.println("  - Busca");
                    System.out.println("\t1 - Livros");
                    System.out.println("\t2 - Usuários");
                    System.out.println("\t3 - Emprestimos");
                    System.out.println("\t0 - Voltar");
                    System.out.println("  - Ações");
                    System.out.println(("  - Sair"));
                    acaoMenu = ler.nextInt();
                    //if(acaoMenu==1);
                    //else if (acaoMenu==2);
                    //else if (acaoMenu==3);
                    //else;
                    break;

                case 3:
                    System.out.println("Escolha a ação desejada: ");
                    System.out.println("  - Gerenciamento ");
                    System.out.println("  - Busca");
                    System.out.println("  - Ações");
                    System.out.println("\t1 - Emprestimos");
                    System.out.println("\t2 - Reservas");
                    System.out.println("\t3 - Multas");
                    System.out.println("\t0 - Voltar");
                    System.out.println(("  - Sair"));
                    acaoMenu = ler.nextInt();
                    //if(acaoMenu==1);
                    //else if (acaoMenu==2);
                    //else if (acaoMenu==3);
                    //else;
                    break;

                default:
                    acaoMenu = -1;
                    break;

            }

            if(acaoMenu==-1) break;

        }//while_end

    }




    public void gerenciamento(int a){
        Scanner ler = new Scanner(System.in);
        if(a==1){
            System.out.println("\tMenu de Gerenciamento de Livros");
            System.out.println("\t1 - Incluir Livro");
            System.out.println("\t2 - Alterar Livro");
            System.out.println("\t3 - Excluir Livro");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();

            switch (a){
                case 1:

                    break;
                case 2: break;
                case 3: break;
            }


        }else{
            System.out.println("\tMenu de Gerenciamento de Usuario");
            System.out.println("\t1 - Incluir Usuario");
            System.out.println("\t2 - Alterar Usuario");
            System.out.println("\t3 - Excluir Usuario");
            System.out.println("\t0 - Voltar");
            a= ler.nextInt();

            switch (a){
                case 1: break;
                case 2: break;
                case 3: break;
            }
        }

    }//end_gerenciamento

    public void busca(int a){

    }











}
