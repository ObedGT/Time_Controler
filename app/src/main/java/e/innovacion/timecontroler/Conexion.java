package e.innovacion.timecontroler;

import android.os.AsyncTask;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion extends AsyncTask<String, Void, Boolean>{
    //Atributos de la conexion
    public Connection conexionMySQL;
    boolean estadoConexion = false;

    @Override
    protected Boolean doInBackground(String... datos) {
        //Declaramos las variables con los parametros de conexión recibidos
        String host = "192.168.1.9";
        String port = "3306";
        String dbName = "uvgmoviles";
        String userName = "root";
        String password = "admon";
        try{
            conexionMySQL = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);
            if(!conexionMySQL.isClosed()){
                estadoConexion = true;
            }
        } catch (SQLException ex) {
            Log.d("Tarea asincrona", ex.getMessage());
        }
        if(estadoConexion == false) {
            try {
                if (conexionMySQL != null) {
                    conexionMySQL.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return estadoConexion;
    }
}
