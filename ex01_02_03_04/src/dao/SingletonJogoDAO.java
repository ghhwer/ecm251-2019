package dao;

import model.Jogo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonJogoDAO {
    private static SingletonJogoDAO instance = null;
    private Connection con;
    public static SingletonJogoDAO getInstance(){
        if(instance == null)
            instance = new SingletonJogoDAO();
        return instance;
    }
    private SingletonJogoDAO(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:meus_jogos.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Jogo> getAllJogos() {
        List<Jogo> jogos = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery("SELECT * FROM jogos;");
            while(rs.next()){
                Jogo jogo = new Jogo(
                        rs.getString("nome"),
                        rs.getString("lancamento"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public boolean insertJogo(Jogo jogo){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = con.prepareStatement(
                    "INSERT INTO jogos VALUES(null, ?, ?,?, ?);"
            );
            comandoSQL.setString(1, jogo.nome);
            comandoSQL.setString(2, jogo.genero);
            comandoSQL.setString(3, jogo.plataforma);
            comandoSQL.setString(4, jogo.lancamento);
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Jogo> getAllJogosByName(String nome) {
        List<Jogo> jogos = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery(
                            "SELECT * FROM jogos WHERE nome LIKE '%" + nome + "%';"
                    );
            while(rs.next()){
                Jogo jogo = new Jogo(
                        rs.getString("nome"),
                        rs.getString("lancamento"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public List<Jogo> getAllJogosByType(String genero) {
        List<Jogo> jogos = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery(
                            "SELECT * FROM jogos WHERE genero LIKE '%" + genero + "%';"
                    );
            while(rs.next()){
                Jogo jogo = new Jogo(
                        rs.getString("nome"),
                        rs.getString("lancamento"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public List<Jogo> getAllJogosByPlataform(String plataforma) {
        List<Jogo> jogos = new ArrayList<>();

        try {
            Statement comandoSql = con.createStatement();
            ResultSet rs = comandoSql.
                    executeQuery(
                            "SELECT * FROM jogos WHERE plataforma LIKE '%" + plataforma + "%';"
                    );
            while(rs.next()){
                Jogo jogo = new Jogo(
                        rs.getString("nome"),
                        rs.getString("lancamento"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getInt("id")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public void updateJogo(Jogo jogo) {
        try {
            Statement comandoSql = con.createStatement();
            comandoSql.executeUpdate("UPDATE jogos SET "+
                    "nome=\"" + jogo.nome + "\"," +
                    "genero=\"" + jogo.genero + "\"," +
                    "plataforma=\"" + jogo.plataforma + "\"," +
                    "lancamento=\"" + jogo.lancamento + "\"" +
                    " WHERE id=" + jogo.id+";");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {

            try {
                Statement comandoSql = con.createStatement();
                comandoSql.executeUpdate(
                        "DELETE FROM jogos WHERE id=" + id+";"
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
