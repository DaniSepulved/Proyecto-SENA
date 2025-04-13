package Usuarios;

public class Usuarios implements Administradores, Clientes, Empleados{
    private int Id_usuario;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Contrasenia;
    private Rol Rol;

    public Usuarios(int id_usuario, String nombre, String apellido, String correo, String contrasenia, Rol rol) {
        Id_usuario = id_usuario;
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Contrasenia = contrasenia;
        Rol = rol;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        Id_usuario = id_usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public Rol getRol(){
        return Rol;
    }

    public void setRol(Rol rol) {
        Rol = rol;
    }

    // @Override
    // public String toString() {
    //     return "Usuarios{" +
    //             "Id_usuario=" + Id_usuario +
    //             ", Nombre='" + Nombre + '\'' +
    //             ", Apellido='" + Apellido + '\'' +
    //             ", Correo='" + Correo + '\'' +
    //             ", Contrasenia='" + Contrasenia + '\'' +
    //             ", Rol=" + Rol +
    //             '}';
    // }
}
