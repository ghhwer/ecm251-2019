package com.company;

public class Main {

    public static void main(String[] args) {
        Produto p1 = new Produto("Abacate");
        Produto p2 = new Produto("Tomate");

        ListaDeCompras L = new ListaDeCompras();

        System.out.println("Adicionando Produtos");
        L.AdicionarProduto(p1);
        L.AdicionarProduto(p2);
        L.listar();

        System.out.println("");
        System.out.println("Removendo um item..");
        System.out.println(L.procurar(p1));
        System.out.println(L.procurar(p2));
        System.out.println(L.remover("Abacate"));
        L.listar();

        System.out.println("");
        System.out.println("Procurando itens e trocando");
        System.out.println(L.procurar(p1));
        System.out.println(L.procurar(p2));
        System.out.println(L.modificar(0,p1));
        L.listar();

        System.out.println("");
        System.out.println("Procurando itens dn");
        System.out.println(L.procurar(p1));
        System.out.println(L.procurar(p2));

    }
}
