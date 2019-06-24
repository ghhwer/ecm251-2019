package com.submarino;
import com.submarino.sistema.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.submarino.sistema.Loja;

public class AtividadeSubmarino {

    static Scanner sc1;
    static Loja loja;
    static ListaDeCompras carrinho;
    static ListaDeCompras desejos;
    static int numeroDoPedido = 0;


    public static void main(String[] args) {
        sc1 = new Scanner(System.in);
        loja = new Loja();
        carrinho = new ListaDeCompras();
        desejos = new ListaDeCompras();

        menuInicial();

    }

    static public void finalizarPedido(){
        System.out.println("Para finalizar a compra entre com os seus dados.");
        sc1.nextLine();
        System.out.println("CPF: ");
        String cpf = sc1.nextLine();
        System.out.println("Nome: ");
        String nome = sc1.nextLine();
        System.out.println("Endereco para entrega: ");
        String endereco = sc1.nextLine();
        System.out.println("CEP: ");
        String cep = sc1.nextLine();
        System.out.println("E por último, um email válido para o envio do boleto: ");
        String email = sc1.nextLine();

        Cliente cli = new Cliente(cpf, nome, endereco, cep, email);

        Pedido pedido = new Pedido( cli , carrinho, numeroDoPedido );
        System.out.println( pedido.resumoPedido() );

        carrinho = new ListaDeCompras();
        cli = null;
        pedido = null;
        numeroDoPedido += 1;
    }


    static public void menuInicial(){
        int op;
        do {

            System.out.println("Bem vindo ao Submarimbo. Seu melhor console de compra.");
            System.out.println("[1] - Todos os produtos");
            System.out.println("[2] - Games");
            System.out.println("[3] - Informática");
            System.out.println("[4] - Livros");
            System.out.println("[5] - Móveis");
            System.out.println("[6] - Visualizar carrinho");
            System.out.println("[7] - Visualizar lista de desejos");
            System.out.println("[8] - Sair");

            op = sc1.nextInt();

            switch (op){
                case 1:
                    menuTodos();
                    break;
                case 2:
                    menuDep(Produto.departamento.games);
                    break;
                case 3:
                    menuDep(Produto.departamento.informatica);
                    break;
                case 4:
                    menuDep(Produto.departamento.livro);
                    break;
                case 5:
                    menuDep(Produto.departamento.moveis);
                    break;
                case 6:
                    menuCarrinho();
                    break;
                case 7:
                    menuDesejos();
                    break;
                case 8: break;
                default:
                    System.out.println("Operação Invalida.");
            }

        } while (op != 8);

    }

    static public void menuTodos(){
        int op;
        do {
            System.out.println("Todos produtos.");
            System.out.println(loja.exibirTodosProdutos());
            System.out.println("[30] - Retornar ao menu anterior");

            op = sc1.nextInt();
            if ( (op >= 0) && (op <= 21) ){
                menuProduto( op );
            } else {
                if ( op !=30  )
                    System.out.println("Operação Invalida.");
            }
        } while (op != 30);

    }

    static public void menuDep(Produto.departamento tempDep){

        int op;
        do {
            System.out.println("Produtos relacionados à "+tempDep);
            Produto[] listTemp = loja.listaPorDepartamento(tempDep);
            System.out.println(loja.exibirListaDeProdutos(listTemp));
            System.out.println("[30] - Retornar ao menu anterior");

            op = sc1.nextInt();
            boolean exists = false;
            if ( (op >= 0) && (op <= 30) ){
                for(int i = 0; i < listTemp.length; i++){
                    if(op == listTemp[i].getCodProd()){
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    menuProduto(op);
                }
            }
            if (op == 30)
                exists = true;
            if ( op != 30 ||  !exists )
                System.out.println("Operação Invalida.");
        } while (op != 30);

    }

    static public void menuProduto( int indexProd){
        int op;
        do {
            System.out.println("===========================================");
            System.out.println(loja.produtos[indexProd].exibirInfos());
            System.out.println("--------------------");
            System.out.println("[1] - Adicionar ao carrinho");
            System.out.println("[2] - Adicionar a lista de desejos");
            System.out.println("[30] - Voltar ao menu anterior");
            System.out.println("===========================================\n\r");
            op = sc1.nextInt();
            boolean b;
            switch (op){
                case 1:
                    b = carrinho.adicionarALista(loja.produtos[indexProd]);
                    if (b){
                        System.out.println("Produto adicionado ao carrinho com sucesso.");
                        System.out.println("Você possui +" + carrinho.getRestantes() + " lugares no carrinho\n\r");
                    } else {
                        System.out.println("Carrinho cheio. Produto não adicionado.");
                    }
                    System.out.println("Aperte uma tecla para voltar ao menu anterior.");
                    sc1.next();
                    op = 30;
                    break;
                case 2:
                    b = desejos.adicionarALista(loja.produtos[indexProd]);
                    if (b){
                        System.out.println("Produto adicionado a lista de desejos com sucesso.");
                        System.out.println("Você possui +" + desejos.getRestantes() + " lugares na lista\n\r");
                    } else {
                        System.out.println("Lista cheio. Produto não adicionado.");
                    }
                    System.out.println("Aperte uma tecla para voltar ao menu anterior.");
                    sc1.next();
                    op = 30;
                    break;
                case 30: break;
                default:
                    System.out.println("Operação Invalida.");
            }

        } while ( op!= 30 );
    }

    static public void menuCarrinho(){
        int op;
        do {
            System.out.println("\n\r================Seu Carrinho======================");
            System.out.println(carrinho.retornarResumo());
            System.out.println("--------------------");
            System.out.println("[1] - Remover ultimo item do carrinho");
            System.out.println("[2] - Finalizar compra");
            System.out.println("[30] - Voltar ao menu anterior");
            System.out.println("===========================================\n\r");
            op = sc1.nextInt();

            boolean b;
            switch (op){
                case 1:
                    b = carrinho.removerUltimoDaLista();
                    if (b){
                        System.out.println("Produto removido.");
                        System.out.println("Você possui +" + carrinho.getRestantes() + " lugares no carrinho\n\r");
                    } else {
                        System.out.println("Carrinho vazio.");
                    }
                    System.out.println("Aperte uma tecla para voltar ao menu anterior.");
                    sc1.next();
                    op = 30;
                    break;
                case 2:
                    finalizarPedido();
                    sc1.next();
                    op = 30;
                    break;
                case 30: break;
                default:
                    System.out.println("Operação Invalida.");
            }

        } while ( op!= 30 );
    }

    static public void menuDesejos(){
        int op;
        do {
            System.out.println("\n\r==============Sua lista de desejos================");
            System.out.println(desejos.retornarResumo());
            System.out.println("--------------------");
            System.out.println("UUUHHHUUUULLLL, quando algum item dessa lista entrar em promoção voce será notificado.");
            System.out.println("[1] - Remover ultimo item da lista");
            System.out.println("[30] - Voltar ao menu anterior");
            System.out.println("===========================================\n\r");
            op = sc1.nextInt();

            boolean b;
            switch (op){
                case 1:
                    b = desejos.removerUltimoDaLista();
                    if (b){
                        System.out.println("Produto removido.");
                        System.out.println("Você possui +" + carrinho.getRestantes() + " lugares no carrinho\n\r");
                    } else {
                        System.out.println("Carrinho vazio.");
                    }
                    System.out.println("Aperte uma tecla para voltar ao menu anterior.");
                    sc1.next();
                    op = 30;
                    break;
                case 30: break;
                default:
                    System.out.println("Operação Invalida.");
            }

        } while ( op!= 30 );
    }



}
