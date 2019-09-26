package e.innovacion.timecontroler;


import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexion {
    //Atributos de la clase
    private String host = "192.168.1.9";
    private String port = "3306";
    private String userName = "root";
    private String password = "admon";
    private String dbName = "seguridadinformatica";

    //Metodo que obtiene la conexion a la base de datos
    public Connection connect() throws ConnectException, SQLException {
        Connection conn;
        try {
            // Creamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    //Metodo que cierra una conexion a la base de datos
    public void disconnect(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Metodos gets y sets
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
