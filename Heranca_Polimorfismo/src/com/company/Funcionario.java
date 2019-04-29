package com.company;

public class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(){

    }

    public Funcionario(String nome){
        this.nome = nome;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public double comissao(){
        return this.salario * 0.1;
    }
}
