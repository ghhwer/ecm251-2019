package com.company;

import auxiliar_database.SingletonUsuariosDAO;
import model.Usuario;
import utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private List<Usuario> users;
    public Aplicacao(){
        users = new ArrayList<>();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        do{
            menu();
            int op = scanner.nextInt();
            int id;
            Usuario resultUser;
            switch (op){
                case 1:
                    String nome, email, senha;
                    System.out.println("Informe:");
                    nome = scanner.next();
                    email = scanner.next();
                    senha = scanner.next();
                    Usuario user = new Usuario(
                            nome, email, senha
                    );
                    SingletonUsuariosDAO.getInstance().insertUsuario(user);
                    break;
                    case 2:
                        users = SingletonUsuariosDAO.getInstance().getAllUsuario();
                        for (Usuario u : users) {
                            System.out.print("ID: " + u.id);
                            System.out.println(" Nome: " + u.nome);
                        }
                    break;
                case 3:
                    System.out.println("Informe o ID:");
                    id = scanner.nextInt();
                    resultUser = SingletonUsuariosDAO.getInstance().getUsuario(id);
                    if(resultUser == null)
                        System.out.println("Usuario nao cadastrado");
                    else{
                        System.out.print("ID: " + resultUser.id);
                        System.out.print(" Nome: " + resultUser.nome);
                        System.out.println(" Email: " + resultUser.email);
                    }
                    break;
                case 4:

                    System.out.println("Informe o ID:");
                    id = scanner.nextInt();
                    resultUser = SingletonUsuariosDAO.getInstance().getUsuario(id);
                    if(resultUser == null)
                        System.out.println("Usuario nao cadastrado");
                    else{
                        System.out.print("ID: " + resultUser.id);
                        System.out.print(" Nome: " + resultUser.nome);
                        System.out.println(" Email: " + resultUser.email);
                        System.out.println("Qual campo atualizar:");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Email");
                        System.out.println("3 - Senha");
                        op = scanner.nextInt();
                        System.out.println("Novo Valor:");
                        String temp = scanner.next();
                        switch (op){
                            case 1: resultUser.nome = temp; break;
                            case 2: resultUser.email = temp; break;
                            case 3: resultUser.senha = temp; break;
                        }
                        SingletonUsuariosDAO.getInstance().updateUserById(resultUser);
                    }

                    break;

                case 5:
                    System.out.println("Id para deletar:");
                    id = scanner.nextInt();
                    SingletonUsuariosDAO.getInstance().deleteUserById(id);
            }
            if(op == 0) break;
        }while(true);
    }
    public void menu(){
        System.out.println("1 - Inserir Usuario");
        System.out.println("2 - Mostrar todos os usuarios");
        System.out.println("3 - Buscar usuario");
        System.out.println("4 - Atualizar usuario");
        System.out.println("5 - Remover usuario");
        System.out.printf("0 - Sair");
    }
}
