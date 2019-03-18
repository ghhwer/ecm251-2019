package com.company;

public class Sayajin {
    public String nome;
    public double ki;
    public boolean odio;
    public int nivelDeSuper;

    public Sayajin(double kiInicial, String Sayajin){
        ki = kiInicial;
        nome = Sayajin;
    }

    public void Treinar(){
        if (odio)
            ki = ki*1.2;
        else
            ki = ki*1.1;
        System.out.println("Depois do treino o poder de luta é: "+ki);
    }

    public String PegarCorDoCabelo(){
        if(nivelDeSuper  == 0)
            return "Preto";
        else if(nivelDeSuper > 0 && nivelDeSuper <= 3)
            return "Amarelo";
        else
            return "Azul";
    }
}
