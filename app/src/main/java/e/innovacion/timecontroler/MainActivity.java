package e.innovacion.timecontroler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnIngresar;
    private ArrayList<Usuario> usuario = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPassword = (EditText) findViewById(R.id.txtPass);
        btnIngresar = (Button) findViewById(R.id.btnLogin);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegacion = new Intent(MainActivity.this, Menu.class);
                Usuario user = validarLogin();
                if(user != null){
                    if(user.getActivo() == 0){
                        Toast.makeText(MainActivity.this, "Usuario inactivo", Toast.LENGTH_LONG).show();
                        txtUsuario.setText("");
                        txtPassword.setText("");
                    } else if(user.getIdRol() == 1 && user.getActivo() == 1){
                        txtUsuario.setText("");
                        txtPassword.setText("");
                        startActivity(navegacion);
                    } else if(user.getIdRol() == 2 && user.getActivo() == 1){
                        txtUsuario.setText("");
                        txtPassword.setText("");
                        startActivity(navegacion);
                    }
                } else{
                    txtUsuario.setText("");
                    txtPassword.setText("");
                    Toast.makeText(MainActivity.this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Funcion que establece la conexion con la base de datos y retorna un objeto de tipo usuario
    public Usuario validarLogin(){
        //Variable que almacenará el resultado de la consulta
        Usuario usuario = null;
        //Asignamos el driver de conexion
        String driver = "com.mysql.jdbc.Driver";
        try{
            //Cargamos el driver con el conector jdbc
            Class.forName(driver).newInstance();
            Usuario user = new Usuario(txtUsuario.getText().toString(), txtPassword.getText().toString(), "", "", 0, 0);
            usuario = new Login().execute(user).get();
        } catch(Exception ex){
            Toast.makeText(MainActivity.this, "Error al conectarse a la BD" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return usuario;
    }
}
