/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Clientes extends Usuario {
    private String fechaNacimiento;
    private ArrayList<String> preferencias;
    private double prestamo;

    public Clientes(String fechaNacimiento, ArrayList<String> preferencias, String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
        this.fechaNacimiento = fechaNacimiento;
        this.preferencias = preferencias;
    }
    
}
