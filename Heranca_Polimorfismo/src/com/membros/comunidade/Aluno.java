package com.membros.comunidade;

public class Aluno extends MembroDaComunidade {
    private String ra;

    public Aluno(String nome, String cpf, String ra){
        super(nome, cpf);
        this.ra = ra;
    }

    @Override
    public String getDados() {
        return super.getDados() + '\t' + ra;
    }
}
