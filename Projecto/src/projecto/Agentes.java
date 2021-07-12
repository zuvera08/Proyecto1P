/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Propiedades.Propiedades;
/**
 *
 * @author PC
 */
public class Agentes extends Usuario {

    private String codigoAgente;
    Scanner sc = new Scanner(System.in);
/////

    public void salir(BaseDatos bd) {
        Usuario u = new Usuario();
       u.iniciarMenu(bd);
    } 

    public void opcionesAgente(BaseDatos bd) {
        String opcion = "";
        do {
            System.out.println("Elija una opcion :");
            System.out.println("REVIZAR BUZON (1):");
            System.out.println("REGISTRAR VENTA (2):");
            System.out.println("Salir(3)");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    revizarBuzon(bd);
                    break;
                case "2":
                    registrarVenta(bd);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }

        } while (!opcion.equals("3"));
        salir(bd);

    }

    public String getCodigoAgente() {
        return codigoAgente;
    }
//////

    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    public Agentes(String codigoAgente, String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
        this.codigoAgente = codigoAgente;
    }

    public void revizarBuzon(BaseDatos bd) {
        ArrayList<Consultas> listaconsultas = new ArrayList<>();
        for (Consultas consul : bd.getConsulta()) {
            if (this.agente.getNombre().equals(consul.getAgente())) {
                listaconsultas.add(consul);
                for (Consultas c : listaconsultas) {
                    System.out.println(c);
                }
                String respuesta = "";
                do {
                    System.out.println("Desea responder alguna consulta?");
                    respuesta = sc.nextLine();
                    sc.next();

                    System.out.println("Ingrese el codigo de consulta que desee reesponder");
                    String cod = sc.nextLine();
                    sc.next();
                    for (Consultas c : listaconsultas) {
                        if (c.getCodigoPropiedad().equals(cod)) {
                            System.out.println("Ingrese su respuesta");
                            String Oracion = sc.nextLine();
                            sc.next();
                            c.setRespuesta(Oracion);
                            System.out.println("Contstado");
                        }
                    }
                } while (respuesta != "NO");

            }
        }

    }

    public void registrarVenta(BaseDatos bd) {
        // se detalla las propiedades de la 
        System.out.println("Ingrese el nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el codigo de la propiedad");
        String codigo = sc.nextLine();
        System.out.println("Ingrese la fecha de la Venta");
        LocalDate diaVenta = LocalDate.parse(sc.nextLine());
        for (Usuario u : bd.getUsuarios()) {
            if (u instanceof Clientes) {
                Clientes c = (Clientes) u;
                if (c.getNombre().equals(nombre)) {
                    for (Propiedades p : bd.getPropiedades()) {
                        if (p.getCodigo().equals(codigo)) {
                            Venta venta = new Venta(p, diaVenta, this.agente, c);
                            bd.getVentas().add(venta);
                        }
                    }

                }
            }
        }

    }
}
   

