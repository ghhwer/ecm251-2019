package com.submarino.classesTest;

import com.submarino.sistema.Cliente;
import com.submarino.sistema.ListaDeCompras;
import com.submarino.classesTest.ListaDeComprasTest;
import com.submarino.sistema.Pedido;
import com.submarino.sistema.Produto;

public class PedidoTest {
    public static Pedido generatePedidoTest(){
        Cliente c1 = ClienteTest.geraClienteTest();
        ListaDeCompras lc1 = ListaDeComprasTest.geraListaTest();
        Pedido p = new Pedido(c1,lc1,1);
        return p;
    }
    public static void main(String[] args) {
        Pedido p = generatePedidoTest();
        System.out.println(p.resumoPedido());
    }

}
