/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import java.util.ArrayList;
import  Propiedades.Propiedades;
/**
     * La clase guarda todas las lista e info usadas en el programa
    
     * @author JosueVera
     */
public class BaseDatos {



    private ArrayList<Usuario> usuarios;
    private ArrayList<Consultas> consultas;
    private ArrayList<Propiedades> propiedades;
    private ArrayList<Venta> ventas;
    
    /**
     * El constructor de la base de datos apra inicialiazr las listas
     * @param  bd
     * @author JosueVera
     */
    public BaseDatos() {
        this.usuarios= new ArrayList<>();
        this.consultas= new ArrayList<>();
        this.propiedades= new ArrayList<>();
        this.ventas= new ArrayList<>();
    }
    
    public ArrayList<Venta> getVentas() {
        return ventas;
    }
    

    public ArrayList<Propiedades> getPropiedades() {
        return propiedades;
    }
    
    public ArrayList<Consultas> getConsulta() {
        return consultas;
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    
}
    

