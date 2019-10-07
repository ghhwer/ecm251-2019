package com.heroimerlin;import java.sql.*;import java.util.ArrayList;import java.util.List;public class SingletonDAO {    private static SingletonDAO instance = null;    private Connection con_products;    private Connection con_users;    private Connection con_sales;    public static SingletonDAO getInstance(){        if(instance == null)            instance = new SingletonDAO();        return instance;    }    private SingletonDAO(){        try {            con_products = DriverManager.getConnection("jdbc:sqlite:Produtos.db");            con_users = DriverManager.getConnection("jdbc:sqlite:Users.db");            con_sales = DriverManager.getConnection("jdbc:sqlite:Sales.db");        } catch (SQLException e) {            e.printStackTrace();        }    }    // PRODUCTS    public List<Product> getAllProdutos() {        List<Product> produtos = new ArrayList<>();        try {            Statement comandoSql = con_products.createStatement();            ResultSet rs = comandoSql.                    executeQuery("SELECT * FROM produtos;");            while(rs.next()){                Product produto = new Product(                        rs.getInt("COD"),                        rs.getString("NAME"),                        rs.getFloat("PRICE"),                        rs.getInt("QUANT"),                        rs.getString("FABRI"),                        rs.getString("CAT")                        );                produtos.add(produto);            }            rs.close();        } catch (Exception e) {            e.printStackTrace();            return null;        }        return produtos;    }    public boolean updateOrAppendFromList(List<Product> products){        try {            for (int i = 0; i < products.size(); i++) {                List<Product> dbList = getAllProdutosByName(products.get(i).name);                if (dbList.size() > 0) {                    products.get(i).productCode = dbList.get(0).productCode;                    updateProduto(products.get(i));                }                else                    insertProduto(products.get(i));            }            return true;        }        catch (Exception e){            e.printStackTrace();            return false;        }    }    public boolean insertProduto(Product produto){        PreparedStatement comandoSQL;        try {            comandoSQL = con_products.prepareStatement(                    "INSERT INTO produtos VALUES(NULL, ?, ?,?, ?, ?);"            );            comandoSQL.setString(1, produto.name);            comandoSQL.setDouble(2, produto.productPrice);            comandoSQL.setInt(3, produto.stockQuant);            comandoSQL.setString(4, produto.manufacturer);            comandoSQL.setString(5, produto.category);            comandoSQL.executeUpdate();        } catch (SQLException e) {            e.printStackTrace();            return false;        } catch (NullPointerException e){            e.printStackTrace();            return false;        } catch (Exception e){            e.printStackTrace();            return false;        }        return true;    }    public List<Product> getAllProdutosByCat(String cat) {        ArrayList<Product> produtos = new ArrayList<Product>();        try {            Statement comandoSql = con_products.createStatement();            ResultSet rs = comandoSql.                    executeQuery(                            "SELECT * FROM produtos WHERE CAT LIKE '%" + cat + "%';"                    );            while(rs.next()){                Product produto = new Product(                        rs.getInt("COD"),                        rs.getString("NAME"),                        rs.getFloat("PRICE"),                        rs.getInt("QUANT"),                        rs.getString("FABRI"),                        rs.getString("CAT"));                produtos.add(produto);            }            rs.close();        } catch (Exception e) {            e.printStackTrace();            return null;        }        return produtos;    }    public void updateProduto(Product produto) {        try {            Statement comandoSql = con_products.createStatement();            comandoSql.executeUpdate("UPDATE produtos SET "+                    "NAME=\"" + produto.name + "\"," +                    "PRICE=\"" + produto.productPrice + "\"," +                    "QUANT=\"" + produto.stockQuant + "\"," +                    "FABRI=\"" + produto.manufacturer + "\"," +                    "CAT=\"" + produto.category + "\"" +                    " WHERE COD=" + produto.productCode+";");        } catch (Exception e) {            e.printStackTrace();        }    }    public Product getProductByCode(int code) {        ArrayList<Product> produtos = new ArrayList<Product>();        try {            Statement comandoSql = con_products.createStatement();            ResultSet rs = comandoSql.                    executeQuery(                            "SELECT * FROM produtos WHERE COD = '" + code + "';"                    );            while(rs.next()){                Product produto = new Product(                        rs.getInt("COD"),                        rs.getString("NAME"),                        rs.getFloat("PRICE"),                        rs.getInt("QUANT"),                        rs.getString("FABRI"),                        rs.getString("CAT"));                produtos.add(produto);            }            rs.close();        } catch (Exception e) {            e.printStackTrace();            return null;        }        return produtos.get(0);    }    public List<Product> getAllProdutosByName(String name) {        ArrayList<Product> produtos = new ArrayList<Product>();        try {            Statement comandoSql = con_products.createStatement();            ResultSet rs = comandoSql.                    executeQuery(                            "SELECT * FROM produtos WHERE NAME = '" + name + "';"                    );            while(rs.next()){                Product produto = new Product(                        rs.getInt("COD"),                        rs.getString("NAME"),                        rs.getFloat("PRICE"),                        rs.getInt("QUANT"),                        rs.getString("FABRI"),                        rs.getString("CAT"));                produtos.add(produto);            }            rs.close();        } catch (Exception e) {            e.printStackTrace();            return null;        }        return produtos;    }    // USERS    public boolean insertUsuario(User usuario){        PreparedStatement comandoSQL;        try {            comandoSQL = con_users.prepareStatement(                    "INSERT INTO usuarios VALUES(?, ?, ?);"            );            comandoSQL.setString(1, usuario.getUser());            comandoSQL.setString(2, usuario.getPass());            comandoSQL.setDouble(3, usuario.getAuthLevel());            comandoSQL.executeUpdate();        } catch (SQLException e) {            e.printStackTrace();            return false;        } catch (NullPointerException e){            e.printStackTrace();            return false;        } catch (Exception e){            e.printStackTrace();            return false;        }        return true;    }    public List<User> getAllUsuariosByUser(String user) {        List<User> usuarios = new ArrayList<>();        try {            Statement comandoSql = con_users.createStatement();            ResultSet rs = comandoSql.                    executeQuery(                            "SELECT * FROM users WHERE USER LIKE '%" + user + "%';"                    );            while(rs.next()){                User usuario = new User(rs.getString("USER")+':'+rs.getString("PASSWORD"),rs.getInt("AUTH_LEVEL"));                usuarios.add(usuario);            }            rs.close();        } catch (Exception e) {            e.printStackTrace();            return null;        }        return usuarios;    }    //public List<Venda> getAllVendas() {    //    List<Venda> vendas = new ArrayList<>();//    //    try {    //        Statement comandoSql = con.createStatement();    //        ResultSet rs = comandoSql.executeQuery("SELECT * FROM sales;");    //        while(rs.next()){    //            Venda venda = new Venda(    //                    rs.getString("USER"),    //                    rs.getString("PRODUCT"),    //                    rs.getInt("QUANT")    //            );    //            vendas.add(venda);    //        }    //        rs.close();    //    } catch (Exception e) {    //        e.printStackTrace();    //        return null;    //    }    //    return vendas;    //}    //public List<Venda> getAllVendasByName(String nome) {    //    List<Venda> vendas = new ArrayList<>();//    //    try {    //        Statement comandoSql = con.createStatement();    //        ResultSet rs = comandoSql.    //                executeQuery(    //                        "SELECT * FROM sales WHERE USER LIKE '%" + nome + "%';"    //                );    //        while(rs.next()){    //            Venda venda = new Venda(    //                    rs.getString("USER"),    //                    rs.getString("PRODUCT"),    //                    rs.getInt("QUANT")    //            );    //            vendas.add(venda);    //        }    //        rs.close();    //    } catch (Exception e) {    //        e.printStackTrace();    //        return null;    //    }    //    return vendas;    //}//    //public boolean insertvENDA(Venda venda){    //    PreparedStatement comandoSQL;    //    try {    //        comandoSQL = con.prepareStatement(    //                "INSERT INTO sales VALUES(?,?,?);"    //        );    //        comandoSQL.setString(1, venda.user);    //        comandoSQL.setString(2, venda.product);    //        comandoSQL.setString(3, venda.quant);    //        comandoSQL.executeUpdate();    //    } catch (SQLException e) {    //        e.printStackTrace();    //        return false;    //    } catch (NullPointerException e){    //        e.printStackTrace();    //        return false;    //    } catch (Exception e){    //        e.printStackTrace();    //        return false;    //    }    //    return true;    //}}