package com.company;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void SayajinExemplo(){
        Sayajin s1 = new Sayajin(1000,"Noia da Muleta");
        Sayajin s2 = new Sayajin(1000000,"Brownie");

        int i = 0;
        int j = 0;

        boolean PararDeTrinar = false;
        double max_ndm = 9000;
        double max_brw = 9000000;
        while (!PararDeTrinar) {
            if (s1.ki <= max_ndm) {
                s1.Treinar();
                i++;
            }
            if (s2.ki <= max_brw) {
                s2.Treinar();
                j++;
            }
            if( (s1.ki >= max_ndm) && (s2.ki >= max_brw) )
                PararDeTrinar = true;

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("\n"+s1.nome+" treinou por: "+i+" vezes até ficar pika");
        System.out.println(s2.nome+" treinou por: "+j+" vezes até ficar pika");
    }
    public static void ContaExemplo(){
        Conta conta1 = new Conta("99999999999","Noia Da Muleta", 1);
        Conta conta2 = new Conta("99999999999","Noia Da Muleta", 1);

        conta1.depositar(10.90);
        conta2.depositar(49.90);

        conta1.visualizarSaldo();
        conta2.visualizarSaldo();

        conta2.sacar(19.00);
        conta2.visualizarSaldo();
        conta2.transferirDinheiro(conta1, 20);

        conta1.visualizarSaldo();
        conta2.visualizarSaldo();

        conta1.sacar(2000);

    }
    public static void main(String[] args) {
        ContaExemplo();
    }
}
