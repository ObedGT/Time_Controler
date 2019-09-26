package e.innovacion.timecontroler;

public class Usuario {
    //Atributos de la clase
    private String loginName;
    private String password;
    private String nombre;
    private String apellido;
    private int idRol;
    private int activo;

    //Constructor que recibe todos los parametros de usuario
    public Usuario(String loginName, String password, String nombre, String apellido, int idRol, int activo){
        this.loginName = loginName;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idRol = idRol;
        this.activo = activo;
    }

    //Constructor sin parametros
    public Usuario(String login_name, String pass, String correo, String nombre, String apellido, int id_estado, int id_rol) {

    }

    //Metodos gets y sets
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
