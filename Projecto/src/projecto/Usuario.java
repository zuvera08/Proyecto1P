/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

/**
 *
 * @author Danielitto
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String cedula;
    private String correo;
    private String contrasenia;

    public Usuario(String usuario, String nombre, String cedula, String correo, String contrasenia) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    class Cliente extends Usuario{
        
    }
    class Administrador extends Usuario{
        
    }
    class Agente extends Usuario{
        
    }

    

}
