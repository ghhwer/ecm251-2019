package com.submarino.classesTest;
import com.submarino.sistema.Cliente;

public class ClienteTest {
    public static Cliente geraClienteTest(){
        Cliente c1 = new Cliente("111.169.444-69","Mia Khalifa","Brazzers Company, Jhon Sins St ","12345789","mia.khalifa@brazzers.com");
        return c1;
    }

    public static void main(String[] args) {
        Cliente c1 = geraClienteTest();

        System.out.println(c1.getCPF());
        System.out.println(c1.getNome());
        System.out.println(c1.getEndereco());
        System.out.println(c1.getCEP());
        System.out.println(c1.getEmail());
    }
}
}
