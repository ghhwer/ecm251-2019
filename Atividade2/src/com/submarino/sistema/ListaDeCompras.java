package com.submarino.sistema;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    private List<Produto> produtos = new ArrayList<>();
    private int espacoNaLista = 12;

    public String retornarResumo(){
       String temp = "";
        for (int i = 0; i< produtos.size();i++){
            temp += produtos.get(i).exibirInfos();
       }
       return temp;
    }

    public boolean removerUltimoDaLista(){
        try{
            Produto p = produtos.remove(produtos.size()-1);
            espacoNaLista += 1;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public int getRestantes(){
        return espacoNaLista;
    }

    public boolean adicionarALista(Produto p){
        try{
            if (espacoNaLista > 0){
                produtos.add(p);
                espacoNaLista -= 1;
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

}
