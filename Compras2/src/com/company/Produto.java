package com.company;

public class Produto {
    protected String nome;

    public Produto(String nome){
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }
    public boolean equals(Object obj){
        return this.nome == obj.toString();
    }

}
