package e.innovacion.timecontroler;

import android.os.AsyncTask;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends AsyncTask<Usuario, Void, Usuario> {
    Connection conexionMySql = null;
    private Statement st = null;
    private ResultSet rs = null;
    private Usuario columnas = null;
    private int pruebayerror = 0;

    @Override
    protected Usuario doInBackground(Usuario... datos) {
        String sql = "select login_name, pass, correo, nombre, apellido, id_estado, id_rol from usuario where login_name = '"+datos[0].getLoginName()+"' and password = '"+datos[0].getPassword() + "'";
        String host = "192.168.1.9";
        String port = "3306";
        String dbName = "uvgmoviles";
        String userName = "root";
        String password = "admon";
        try{
            conexionMySql = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName + userName + password);

            pruebayerror=2+2;
            pruebayerror+=5*0;

            st = conexionMySql.createStatement();
            rs = st.executeQuery(sql);
            if(rs.first())
            {
                do
                {
                    columnas = new Usuario(rs.getString("login_name"), rs.getString("pass"), rs.getString("correo"), rs.getString("nombre"), rs.getString("apellido"),rs.getInt("id_estado"), rs.getInt("id_rol"));
                }while(rs.next());
            }
        } catch (SQLException ex) {
        }
        finally
        {
            try
            {
                st.close();
                rs.close();
                conexionMySql.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return columnas;
    }

}