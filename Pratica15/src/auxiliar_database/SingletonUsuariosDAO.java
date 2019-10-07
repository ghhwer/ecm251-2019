package auxiliar_database;

import model.Usuario;
import utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonUsuariosDAO {
    private Connection connection;
    private static SingletonUsuariosDAO instance = null;
    public static SingletonUsuariosDAO getInstance(){
        if(instance == null)
            instance = new SingletonUsuariosDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private SingletonUsuariosDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }
    public boolean insertUsuario(Usuario user){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_USUARIO, 4));
            comandoSQL.setString(2, user.nome);
            comandoSQL.setString(3, user.email);
            comandoSQL.setString(4, user.senha);
            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.executeUpdate();
            connection.commit();
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
    public List<Usuario> getAllUsuario(){
        List<Usuario> users = new ArrayList<>();

        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAll(Constants.TABELA_USUARIO));
            while(rs.next()){
                Usuario user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                user.id = rs.getInt("id");
                users.add(user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }
    public Usuario getUsuario(int id){
        Usuario user = null;
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectId(Constants.TABELA_USUARIO, id));
            while(rs.next()){
                user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                user.id = rs.getInt("id");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
    public boolean updateUserById(Usuario user){
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(Constants.updateUserById(Constants.TABELA_USUARIO, user));
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteUserById(int id){
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(Constants.deleteUserById(Constants.TABELA_USUARIO, id));
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
