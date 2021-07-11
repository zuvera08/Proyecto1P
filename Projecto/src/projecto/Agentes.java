/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Agentes extends Usuario {
    private String codigoAgente;
    Scanner sc= new Scanner(System.in);
    public Agentes(String codigoAgente, String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
        this.codigoAgente = codigoAgente;
    }
    
    public void salir(BaseDatos bd) {
        Usuario u = new Usuario();
        u.iniciarMenu(bd);
    }
    public void opcionesAgente(BaseDatos bd){
        String opcion= "";
        do{
        System.out.println("Elija una opcion :");
        System.out.println("REGISTRAR PROPIEDAD (1):");
        System.out.println("REGISTRAR AGENTE (2):");
        System.out.println("VER REPORTE AGENTE Y VENTAS (3):");
        System.out.println("Salir(4)");
        opcion= sc.next();
        sc.nextLine();
        switch(opcion){
        case "1":
            revizarBuzon(bd);
           break;
        case "2":
            registrarVenta(bd);
            break;
  
          }  
    
        }while(!opcion.equals("3"));
        salir(bd);
        
    }
    public String getCodigoAgente() {
        return codigoAgente;
    }
//////
    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }
    public void revizarBuzon(BaseDatos bd){
        ArrayList<Consultas> listaconsultas= new ArrayList<>();
        for(Consultas consul: bd.getConsulta()){
            if(this.agente.getNombre().equals(consul.getAgente())) {
                listaconsultas.add(consul);
                for (Consultas c: listaconsultas ){
                    System.out.println(c);
                }
                String respuesta="";
                do{
                System.out.println("Desea responder alguna consulta?");
                respuesta= sc.nextLine();
                sc.next();
                    
                System.out.println("Ingrese el codigo de propiedad que desee reesponder");
                String cod= sc.nextLine();
                sc.next();
                for(Consultas c: listaconsultas){
                    if(c.getCodigoPropiedad().equals(cod)){
                        System.out.println("Ingrese su respuesta");
                        String Oracion= sc.nextLine();
                        c.setRespuesta(Oracion);
                        System.out.println("Contstado");
                    } 
                }
                }while(respuesta !="NO");
       
            }          
        }
        
    }
   public void registrarVenta(BaseDatos bd){}
        // se detalla las propiedades de la venta
       // System.out.println("Ingrese el precio del objeto");
       // double precio= sc.nextInt();
       // System.out.println("Ingrese el ancho del objeto");
       // double ancho= sc.nextInt();
        //System.out.println("Ingrese la profundidad del objeto");
       // double precio= sc.nextInt();
        //System.out.println("Ingrese el precio del objeto");
       //double precio= sc.nextInt();
        //System.out.println("Ingrese el precio del objeto");
        //double precio= sc.nextInt();
    
        //Propiedad(double precio, double ancho, double profundidad, Ubicacion  ubicacion , Agentes  agente , String codigo)
        //Venta venta = new Venta(Propiedades p,fechaVenta, codigoAgente, usuario);  
    }
   

