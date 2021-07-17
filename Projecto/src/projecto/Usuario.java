/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import projecto.Administradores;
import java.time.Period;
import java.util.ArrayList;
import java.util.UUID;
import projecto.BaseDatos;
/* La clase define los Usuarios , clase padre y  atributos de usuario,nombre,cedula,etc. y sus metodos
     * 
     * @author JosueVera
     */
public class Usuario {
    private String usuario;
    private String nombre;
    private String cedula;
    private String correo;
    private String contrasenia;

    public Usuario() {
    }
    
   /** Constructor para incinializar variables
     * @param usuario
     * * @param  nombre
     * * @param cedula
     * * @param correo
     * * @param contrasenia
     * @author JosueVera
     */
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
    /** metodos para mostrar el menu
     * @param bd
     
     * @author JosueVera
     */
    
    public void salir(BaseDatos bd) {
        Usuario u = new Usuario();
       u.iniciarMenu(bd);
    }
    public  void iniciarMenu(BaseDatos bd){
    Scanner sc= new Scanner(System.in);
    System.out.println("IniciarSesion (1)");
    System.out.println("Registrar(2)");
    System.out.println("Ingrese la opcion que desee realizar(1 o 2)");
    String opcion= sc.nextLine();
    do {
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
            System.out.println("Ingrese su correo");
            String correo=  sc.nextLine();
            System.out.println("Ingrese la fecha de Nacimiento (año-mes-dia(EN NUMEROS))");
            String fechaNacimiento= sc.nextLine();
            LocalDate actual = LocalDate.now();
            int años = Period.between(LocalDate.parse(fechaNacimiento), actual).getYears();
            
            if(años > 18){
                System.out.println("Ingrese el usuario");
                String usuario2= sc.nextLine();
                System.out.println("Ingrese la contrasenia :");
                String contrasenia2= sc.nextLine();
                String codigo = UUID.randomUUID().toString().toUpperCase();
                registrarse(nombre,LocalDate.parse(fechaNacimiento),cedula ,usuario2,contrasenia2,codigo,correo,bd );
                break;
                
            }
            if (años<18){
                 System.out.println("Usted es menor de edad, no puede registrarse");
                 break;
            }
            
        default:
        System.out.println("Opcion Incorrecta");
            break; 
        }
    }while(!opcion.equals(""));
    
            
        
    }
            
    

    
/** Metodo que reemplazaza al equals :)
     * @param obj
     * @author JosueVera
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Usuario otro = (Usuario) obj; 
            if(otro.getUsuario().equals(this.usuario) && otro.getContrasenia().equals(this.contrasenia)){
            return true;
            }
            
        
        }
        return false;
    }
    /** Metodo que muestrar la opcion de iniciar sesion 
     * @param usuario
     * * @param  bd
     * * @param contrasenia
     * @author JosueVera
     */
    public void iniciarSesion( String usuario, String contrasenia, BaseDatos bd){
       Usuario u= new Usuario(usuario,contrasenia);
        
       for(Usuario usu : bd.getUsuarios()){
          
           if(usu.equals(u)){
                if(usu instanceof Administradores){
                    System.out.println("Bienvenido Admin");
                    Administradores administrador= (Administradores)usu;
                    administrador.opcionesAdministrador(bd);
                }
                else if(usu instanceof Clientes){
                    System.out.println("Bienvenido Cliente");
                    Clientes cliente= (Clientes)usu;
                    cliente.opcionesCliente(bd);
                }
                else if(usu instanceof Agentes){
                    System.out.println("Bienvenido Agente");
                    Agentes agente= (Agentes)usu;
                    agente.opcionesAgente(bd);
                }
           }
           }   
       
       
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", contrasenia=" + contrasenia;
    }
    
    /** MEtodo ara registrar exclusivamente a los clientes
     * @param nombre
     * * @param  LocalDate
     * * @param cedula
     * * @param usuario
     * * @param contrasenia
     * @param codigo
     * @param bd
     * @author JosueVera
     */
     
    public void registrarse(String nombre,LocalDate fechaNacimiento,String cedula ,String usuario,String contrasenia ,String codigo,String correo,BaseDatos bd){
        Scanner sc= new Scanner(System.in);     
        Alerta a= null;
        Usuario cliente= new Clientes(fechaNacimiento,a,usuario ,nombre,cedula,correo ,contrasenia);
        bd.getUsuarios().add(cliente);
        System.out.println("Registro Exitoso");
        salir(bd);
    }
    
    

}