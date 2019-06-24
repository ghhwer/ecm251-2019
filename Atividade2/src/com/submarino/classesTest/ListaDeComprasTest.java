package com.submarino.classesTest;
import com.submarino.sistema.Produto;
import com.submarino.sistema.ListaDeCompras;

public class ListaDeComprasTest {
    public static ListaDeCompras geraListaTest(){
        Produto p1 = new Produto(1, "Teclado", Produto.departamento.informatica, 3.0, 3.0, 45,"RGB - MARCA BENGAY");
        Produto p2 = new Produto(2, "Rato", Produto.departamento.informatica, 3.0, 3.0, 45,"O nome dele é jimmy");
        Produto p3 = new Produto(3, "Monitor", Produto.departamento.informatica, 3.0, 3.0, 45,"144 MHz 140p");
        Produto p4 = new Produto(4, "Geoge Forman", Produto.departamento.informatica, 3.0, 3.0, 45,"Um bom Grill");

        ListaDeCompras c1 = new ListaDeCompras();
        c1.adicionarALista(p1);
        c1.adicionarALista(p2);
        c1.adicionarALista(p3);
        c1.adicionarALista(p4);
        return c1;
    }

    public static void main(String[] args) {
        ListaDeCompras c1 = geraListaTest();

        System.out.println(c1.retornarResumo());
        System.out.println(c1.getRestantes());
        c1.removerUltimoDaLista();
        System.out.println(c1.retornarResumo());
        System.out.println(c1.getRestantes());
    }
}
