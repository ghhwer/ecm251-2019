package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {
    private List<Produto> produtos;

    public ListaDeCompras(){
        produtos = new ArrayList<Produto>();
    }

    public boolean AdicionarProduto(Produto p){
        try {
            if (p != null)
                produtos.add(p);
            else
                return false;
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public boolean remover(String Nome){
        return produtos.remove(new Produto(Nome));
    }

    public void listar(){
        for (int x = 0; x < produtos.size(); x++) {
            System.out.println(produtos.get(x).toString());
        }
    }
    public int procurar(Produto p) {
        try {
            return produtos.indexOf(p);
        }catch(Exception e) {
            return -1;
        }
    }
    public boolean modificar(int idx, Produto p) {
        try {
            produtos.set(idx, p);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
