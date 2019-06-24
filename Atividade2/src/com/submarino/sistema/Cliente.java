package com.submarino.sistema;

public class Cliente {
    private String CPF;
    private String Nome;
    private String Endereco;
    private String CEP;
    private String Email;

    public Cliente(String CPF,String Nome,String Endereco,String CEP,String Email){
        this.CPF = CPF;
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.CEP = CEP;
        this.Email = Email;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public String getEmail() {
        return Email;
    }
}
