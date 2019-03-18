package com.company;

public class Conta {
    public int numero;
    public String titular;
    public double saldo;
    public String CPF;

    public Conta(String CPF,String titular,int numero){
        this.numero = numero;
        this.titular = titular;
        this.CPF = CPF;
    }

    public void visualizarSaldo(){
        System.out.println(this.titular+" saldo é: " + saldo);
    }
    public void depositar(double valorDoDeposito){
        saldo+=valorDoDeposito;
    }
    public boolean sacar(double valorDoSaque){
        if (saldo >= valorDoSaque){
            saldo-=valorDoSaque;
            return true;
        }
        else{
            System.out.println("Saldo Insuficiente!");
            return false;
        }
    }
    public void transferirDinheiro(Conta dst, double valorDoDeposito){
        boolean tinheroDeuCerto = sacar(valorDoDeposito);
        if (tinheroDeuCerto) dst.depositar(valorDoDeposito);
        else return;
    }
}
