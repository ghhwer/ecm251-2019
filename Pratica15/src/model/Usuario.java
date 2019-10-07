package model;

import utilities.Constants;

public class Usuario {
    public int id;
    public String nome, senha, email;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = Constants.ID_NULO;
    }
}
