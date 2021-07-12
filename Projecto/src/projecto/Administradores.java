/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import Propiedades.Propiedades;
import Propiedades.Ubicacion;
import Propiedades.Casas;
import Propiedades.Terreno;
import Propiedades.TiposTerreno;
import projecto.Agentes;

/**
 *
 * @author PC
 */
/**
     * La clase define los administrados que se extiendes de Usuarios, Los mismos poseen atributos de usuario,nombre,cedula,etc.
     * 
     * @author JosueVera
     */
public class Administradores extends Usuario {
    Scanner sc = new Scanner(System.in);
    /**
     * Constructor para los administradores
     * @param  usuario 
     * @param  nombre 
     * @param  cedula 
     * @param  correo 
     * @param  contrasenia 
     * 
     * @author JosueVera
     */
    public Administradores(String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
    }
    /**
     * Metodo nos retorna al menu principal
     * @param bd El parametro bd es la base de datos
     * @author JosueVera
     */
    public void salir(BaseDatos bd) {
        Usuario u = new Usuario();
       u.iniciarMenu(bd);
    } 
/**
     * Metodo reciebe la base de datos para retornal y mostrar las opciones correspondientes al aDMINISTRADOR
     * @param bd El parametro bd es la base de datos
     * @author JosueVera
     */

     public void opcionesAdministrador(BaseDatos bd) {
        String opcion = "";
        do {
            System.out.println("Elija una opcion :");
            System.out.println("REGISTRAR PROPIEDAD (1):");
            System.out.println("REGISTRAR AGENTE (2):");
            System.out.println("VER REPORTE AGENTE Y VENTAS (3):");
            System.out.println("Salir(4)");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    registrarPropiedad(bd);
                    break;
                case "2":
                    registrarAgente(bd);
                    break;
                case "3":
                    verReporteDeVentasYContactos(bd);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                break;
            }

        } while (!opcion.equals("4"));
        salir(bd);
        

    }
     /**
     * Metodo que ayuda a conseguir un agente de forma aletoria existente en la lista de Usuarios de tipo Agente de la Base de Datos
     * @param  usuarios Lista de usuarios dentro de la base de datos
     * @author JosueVera
     */
    public static Agentes randomAgente(ArrayList<Usuario> usuarios) {
        ArrayList<Agentes> agentes = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u instanceof Agentes) {
                Agentes agent = (Agentes) u;
                agentes.add(agent);
            }
        }
        Random rand = new Random();
        Agentes randomAgente = agentes.get(rand.nextInt(agentes.size()));
        return randomAgente;
    }
    /**
     * Metodo que registrar las Propiedades en la Lista Propiedades dentro de la base de datos
     * @param bd El parametro bd es la base de datos
     * @author JosueVera
     */
    public void registrarPropiedad(BaseDatos bd) {
        System.out.println("Ingrese la propiedad a registrar (TERRENO o CASAS)");
        String propiedad = sc.nextLine().toUpperCase();
        System.out.println("Ingrese el precio de la propiedad :");
        double precio = sc.nextDouble();
        System.out.println("Ingrese la tasa de interes de la propiedad :");
        double tasa = sc.nextDouble();
        System.out.println("Ingrese el ancho de la propiedad :");
        double ancho = sc.nextDouble();
        System.out.println("Ingrese la profundidad de la propiedad :");
        double profundidad = sc.nextDouble();
        sc.next();
        System.out.println("Ingrese el provincia de la propiedad :");
        String provincia = sc.nextLine();
        System.out.println("Ingrese la ciudad de la propiedad :");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese la direccion de la propiedad :");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el sector de la propiedad :");
        String sector = sc.nextLine();
        Ubicacion ubi = new Ubicacion(provincia, ciudad, direccion, sector);
        Agentes agente = randomAgente(bd.getUsuarios());
        if (propiedad.equals("TERRENOS")) {
            System.out.println("Ingrese el tipo del Terreno :");
            String tipoTerreno = sc.nextLine();
            String codigo = UUID.randomUUID().toString().toUpperCase().substring(0, 9);
            Terreno terreno = new Terreno( precio, ancho, profundidad, ubi, agente, codigo,tasa, TiposTerreno.valueOf(tipoTerreno));
            bd.getPropiedades().add(terreno);
            System.out.println("REGISTRADO");
        }
        if (propiedad.equals("CASAS")) {
            System.out.println("Ingrese el numero de pisos de la propiedad :");
            int numPisos = sc.nextInt();
            System.out.println("Ingrese el numero de habitaciones de la propiedad :");
            int numHabitaciones = sc.nextInt();
            String codigo = UUID.randomUUID().toString().toUpperCase();
            Casas casa = new Casas(numPisos,numHabitaciones, precio, ancho, profundidad, ubi, agente, codigo,tasa);
            bd.getPropiedades().add(casa);
            System.out.println("REGISTRADO");
        }
    }
    
    /**
     * Metodo que registrar un nuevo Agente y pasa a la Lista de Usuarios de Tipo Agente, el mismo genera un codigo aleatorio para el mismo
     * @param bd El parametro bd es la base de datos
     * @author JosueVera
     */
    public void registrarAgente(BaseDatos bd) {
        //String codigoAgente, String usuario, String nombre, String cedula, String correo, String contrasenia
        String codigoAgente = UUID.randomUUID().toString().toUpperCase().substring(0, 6);
        System.out.println("Ingrese el Usuario del agente :");
        String usuario = sc.next();
        System.out.println("Ingrese el nombre de agente:");
        String nombre = sc.next();
        System.out.println("Ingrese la cedula del agente :");
        String cedula = sc.next();
        System.out.println("Ingrese el correo del agente:");
        String correo = sc.next();
        String contraseñia = UUID.randomUUID().toString().toUpperCase().substring(0, 6);
        Agentes agente = new Agentes(codigoAgente, usuario, nombre, cedula, correo, contraseñia);
        bd.getUsuarios().add(agente);
        System.out.println("REGISTRADO");
    }
    
    /**
     * Metodo muestra Reporte de ventas y info de Clientes, este puede ser mostrado por parametro de un Agente en especifica que se haya involucrado y por Rango de fechas
     * @param bd El parametro bd es la base de datos
     * @author JosueVera
     */

    public void verReporteDeVentasYContactos(BaseDatos bd) {
        //LocalDate  DiaInicial, LocalDate DiaFinal
        System.out.println("Ingrese el Dia Inicial(AÑO-MES-DIA)(EN NUMEROS)");
        String ingresoDia = sc.nextLine();
        LocalDate diaInicial = LocalDate.parse(ingresoDia);
        System.out.println("Ingrese el Dia Final(AÑO-MES-DIA)(EN NUMEROS)");
        String ingresoFinal = sc.nextLine();
        LocalDate diaFinal = LocalDate.parse(ingresoFinal);
        System.out.println("Desea ver el reporte con un Agente especifico?");
        String respuesta = sc.nextLine().toUpperCase();
        if (respuesta.equals("SI")) {
            System.out.println("Ingrese el nombre del Agente");
            String nombreAgente = sc.nextLine();
            ArrayList<Venta> listaventas = new ArrayList<>();
            ArrayList<Venta> listaventas2 = new ArrayList<>();
            for (Venta vent : bd.getVentas()) {
                if (vent.getAgente().getNombre().equals(nombreAgente)) {
                    listaventas.add(vent);
                }
            }
            for (Venta ventas : listaventas) {
                 if(diaInicial.isBefore(ventas.getFecha()) && diaFinal.isAfter(ventas.getFecha())) {
                     
                        listaventas2.add(ventas);
                    }
                }
            for (Venta l : listaventas2){
                System.out.println(l);
            }            
            }
         else if (respuesta.equals("NO")) {
            ArrayList<Venta> listaventas3 = new ArrayList<>();
            System.out.println("se esta ejecutando el no");
            for (Venta vent : bd.getVentas()) {
                if(diaInicial.isBefore(vent.getFecha()) && diaFinal.isAfter(vent.getFecha())){
                //for (LocalDate date = diaInicial; date.isBefore(diaFinal); date = date.plusDays(1)){
                        listaventas3.add(vent);
                    }
                //}
            }
            for (Venta l : listaventas3){
                System.out.println(l);
            }
        }   
    }
}
