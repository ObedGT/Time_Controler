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

    @Override
    protected Usuario doInBackground(Usuario... datos) {
        String sql = "select pk_login_name, password, nombre, apellido, fk_id_rol, activo from usuario where pk_login_name = '"+datos[0].getLoginName()+"' and password = '"+datos[0].getPassword() + "'";
        String host = "192.168.43.120";
        String port = "3306";
        String dbName = "uvgmoviles";
        String userName = "root";
        String password = "admon";
        try{
            conexionMySql = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName, userName, password);
            st = conexionMySql.createStatement();
            rs = st.executeQuery(sql);
            if(rs.first())
            {
                do
                {
                    columnas = new Usuario(rs.getString("pk_login_name"), rs.getString("password"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("fk_id_rol"), rs.getInt("activo"));
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