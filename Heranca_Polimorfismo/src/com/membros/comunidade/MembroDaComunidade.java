package com.membros.comunidade;

public class MembroDaComunidade {
    protected String nome;
    protected String cpf;

    public String getDados(){
        return nome + '\t' + cpf;
    }

    public MembroDaComunidade(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
}
