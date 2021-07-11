/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

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
    public Administradores administrador;
    public Agentes agente;
    public Usuario() {
    }

    public Usuario(String usuario, String nombre, String cedula, String correo, String contrasenia) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
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
    public  void iniciarMenu(BaseDatos bd){
    Scanner sc= new Scanner(System.in);
    System.out.println("IniciarSesion (1)");
    System.out.println("Registrar(2)");
    System.out.println("Ingrese la opcion que desee realizar(1 o 2)");
    String opcion= sc.nextLine();
    switch(opcion){
        case("1"):
            System.out.println("Ingrese el usuario");
            String usuario= sc.nextLine();
            System.out.println("Ingrese el contraseña");
            String contrasenia= sc.nextLine();
            iniciarSesion(usuario,contrasenia,bd);
        break;
        case("2"):
            System.out.println("Ingrese el nombre");
            String nombre= sc.nextLine();
            System.out.println("Ingrese la cedula");
            String cedula= sc.nextLine();
            System.out.println("Ingrese la fecha de Nacimiento");
            String fechaNacimiento= sc.nextLine();
            LocalDate actual = LocalDate.now();
            int años = Period.between(LocalDate.parse(fechaNacimiento), actual).getYears();
            
            if(años > 18){
                System.out.println("Ingrese el usuario");
                String usuario2= sc.nextLine();
                System.out.println("Ingrese la contrasenia :");
                String contrasenia2= sc.nextLine();
                String codigo = UUID.randomUUID().toString().toUpperCase();
                registrarse(nombre,LocalDate.parse(fechaNacimiento),cedula ,usuario2,contrasenia2,codigo,bd );
                break;
                
            }
            if (años<18){
                 System.out.println("Usted es menor de edad, no puede registrarse");
                 break;
            }
            }
            
        
    }
            
    

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (Objects.equals(this.usuario, other.usuario)) {
            return true;
        }
        if (Objects.equals(this.contrasenia, other.contrasenia)) {
            return true;
        }
        return false;
    }
    
    public void iniciarSesion( String usuario, String contrasenia, BaseDatos bd){
       Usuario u= new Usuario(usuario,contrasenia);
        
       for(Usuario usu : bd.getUsuarios()){
           System.out.println("Ingresando...");
           if(usu!= null){
           if(usu.equals(u)){
               System.out.println("Ta bueno");
               
                if(usu instanceof Administradores){
                   
                    administrador= (Administradores)usu;
                    administrador.opcionesAdministrador(bd);
                }
                if(usu instanceof Clientes){
                }
                if(usu instanceof Agentes){
                    agente= (Agentes)usu;
                    agente.opcionesAgente(bd);
                }
           }
           }   
       }
       
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", contrasenia=" + contrasenia;
    }
    
    
    public void registrarse(String nombre,LocalDate fechaNacimiento,String cedula ,String usuario,String contrasenia ,String codigo,BaseDatos bd){
         ArrayList <String> a= new ArrayList <> ();
        Usuario cliente= new Clientes(fechaNacimiento,a,usuario ,nombre,cedula,contrasenia ,codigo);
        bd.getUsuarios().add(cliente);
    }
    
    

}
