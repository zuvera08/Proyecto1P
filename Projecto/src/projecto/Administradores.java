/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Administradores extends Usuario {
    Scanner sc = new Scanner(System.in);
    public Administradores(String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
    }
public void salir() {
    
    }

    public void opcionesAdministrador(BaseDatos bd) {
        String opcion = "";
        do {
            System.out.println("Elija una opcion :");
            System.out.println("REGISTRAR PROPIEDAD (1):");
            System.out.println("REGISTRAR AGENTE (2):");
            System.out.println("VER REPORTE AGENTE Y VENTAS (3):");
            System.out.println("Salir(4)");
            opcion = sc.next();
            sc.nextLine();
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
            }

        } while (opcion != "4");
        salir();
        sc.close();

    }
}
