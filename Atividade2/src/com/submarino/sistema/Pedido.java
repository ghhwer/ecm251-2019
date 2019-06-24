package com.submarino.sistema;

public class Pedido {
    private Cliente cli;
    private ListaDeCompras carrinho;
    private int numPedido;

    public Pedido(Cliente cli, ListaDeCompras carrinho, int numPedido) {
        this.cli = cli;
        this.carrinho = carrinho;
        this.numPedido = numPedido;
    }

    public String resumoPedido(){
        String temp;
        temp  = "------------------------------------------\n";
        temp += "|                VALEU                    |\n";
        temp += "------------------------------------------\n";
        temp += "Senhor(a) "+cli.getNome()+" seu pedido foi\n";
        temp += "gerado com sucesso \n";
        temp += "Numro do pedido: "+numPedido+"\n";
        temp += "NOME: "+cli.getNome()+'\n';
        temp += "CPF: "+cli.getCPF()+'\n';
        temp += "Endereço de Entrega: "+'\n';
        temp += cli.getEndereco()+" - "+cli.getCEP()+'\n';
        temp += carrinho.retornarResumo()+'\n';
        temp += "Um boleto foi enviado para o email:"+'\n';
        temp += cli.getEmail();
        return temp;
    }

}
