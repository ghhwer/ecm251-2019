package com.membros.comunidade;

public class Main {
    static void mostrarDados(MembroDaComunidade mdc){
        System.out.println(mdc.getDados());
    }
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Adolfo", "1", "69");
        Graduado graduado = new Graduado("Jose", "2", "Advanced Computação");
        Funcionario funcionario = new Funcionario("Mineiro", "minas");
        mostrarDados(aluno);
        mostrarDados(graduado);
        mostrarDados(funcionario);
    }
}
