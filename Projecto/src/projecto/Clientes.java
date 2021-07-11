/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import Propiedades.Casas;
import Propiedades.Propiedades;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Clientes extends Usuario {
    private LocalDate fechaNacimiento;
    private ArrayList<String> preferencias;
    private double prestamo;
    
    public void salir() {
    }
    public void opcionesCliente(BaseDatos bd) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.println("Elija una opcion :");
            System.out.println("CONSULTAR PROPIEDADES DISPONIBLES (1):");
            System.out.println("Consultar Buzon Consultas(2):");
            System.out.println("Crear Alerta (3):");
            System.out.println("Simular Prestamo (4)");
            opcion = sc.next();
            sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el precio minimo");
                    double precioMin= sc.nextInt();
                    System.out.println("Ingrese el precio maximo");
                    double precioMax= sc.nextInt();
                    sc.next();
                    System.out.println("Ingrese el tipo de propiedad");
                    String tipoPropiedad= sc.nextLine();
                    String fechaNacimiento= sc.nextLine();
                    System.out.println("Ingrese la ciudad");
                    String ciudad= sc.nextLine();
                    System.out.println("Ingrese el sector");
                    String sector= sc.nextLine();
                    consultarPropiedadesDisponibles(precioMin,precioMax, tipoPropiedad, ciudad, sector,bd) ;
                    break;
                case "2":
                    //consultas(bd);
                    break;
                case "3":
                    //crearalertas(bd);
                    break;
                    
                case "4":
                   //SimularPrestamos(bd);
                   break;
            }

        } while (opcion != "5");
        salir();
    }
    public Clientes(LocalDate fechaNacimiento, ArrayList<String> preferencias, String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
        this.fechaNacimiento = fechaNacimiento;
        this.preferencias = preferencias;
    }
    public ArrayList<Propiedades> consultarPropiedadesDisponibles(double precioMin, double precioMax, String tipoPropiedad, String ciudad, String sector,BaseDatos bd ){
        ArrayList<Propiedades> propiedadesDisponibles=new  ArrayList<>();
        for (Venta e: bd.getVentas()){
            switch (tipoPropiedad){
                case "casa":
                    if (e.getPropiedad() instanceof Casas){
                        Casas casa=(Casas)e.getPropiedad();
                        if(casa.getUbicacion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())){
                            if(casa.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }else{
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }
                        }else{
                            if(casa.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }else{
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }
                        }
                    }
                    
                    break;
                case "terreno":
                    if (e.getPropiedad() instanceof Propiedades){
                        Propiedades propiedad=(Propiedades)e.getPropiedad();
                        if(propiedad.getUbicacion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())){
                            if(propiedad.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }else{
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }
                        }else{
                            if(propiedad.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }else{
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }
                        }
                    }
                    break;
                default:
                    Propiedades p=e.getPropiedad();
                    if(p.getUbicacion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())){
                            if(p.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }else{
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }
                        }else{
                            if(p.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }else{
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }
                        }
                    }
                    
                }
        return propiedadesDisponibles;
        }
    
}
