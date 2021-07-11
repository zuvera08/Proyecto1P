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
public class Administradores extends Usuario {
    Scanner sc = new Scanner(System.in);
    public Administradores(String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
    }
public void salir(BaseDatos bd) {
        Usuario u = new Usuario();
        u.iniciarMenu(bd);
    }

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

    public void registrarPropiedad(BaseDatos bd) {
        System.out.println("Ingrese la propiedad a registrar (TERRENO o CASAS)");
        String propiedad = sc.nextLine().toUpperCase();
        System.out.println("Ingrese el precio de la propiedad :");
        double precio = sc.nextInt();
        System.out.println("Ingrese el ancho de la propiedad :");
        double ancho = sc.nextInt();
        System.out.println("Ingrese la profundidad de la propiedad :");
        double profundidad = sc.nextInt();
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
            Terreno terreno = new Terreno( precio, ancho, profundidad, ubi, agente, codigo, TiposTerreno.valueOf(tipoTerreno));
            bd.getPropiedades().add(terreno);
            System.out.println("REGISTRADO");
        }
        if (propiedad.equals("CASAS")) {
            System.out.println("Ingrese el numero de pisos de la propiedad :");
            int numPisos = sc.nextInt();
            System.out.println("Ingrese el numero de habitaciones de la propiedad :");
            int numHabitaciones = sc.nextInt();
            String codigo = UUID.randomUUID().toString().toUpperCase();
            Casas casa = new Casas(numPisos,numHabitaciones, precio, ancho, profundidad, ubi, agente, codigo);
            bd.getPropiedades().add(casa);
            System.out.println("REGISTRADO");
        }
    }

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
