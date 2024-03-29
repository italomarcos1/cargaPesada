package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource{

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;

    private Connection connection;

    public DataSource(){
        try {
            hostname = "localhost";
            port = 3306;
            database = "TRANSPORTADORA";
            username = "root";
            password = "bd201901";

            String url = "jdbc:mysql://"+hostname+":"+port+"/"+database+"?autoReconnect=true&useSSL=false";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Conexão bem sucedida.");

        }
        catch (SQLException ex){
            System.err.println("Falha de conexao. "+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro genérico."+ex.getMessage());
        }

    }

    public Connection getConnection(){
        return this.connection;
    }

    public void closeDataSource(){
        try{
            connection.close();
        }
        catch (Exception ex){
            System.err.println("Erro ao desconectar."+ex.getMessage());
        }
    }

}