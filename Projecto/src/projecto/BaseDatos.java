/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import java.util.ArrayList;
import  Propiedades.Propiedades;
/**
 *
 * @author Danielitto
 */
public class BaseDatos {


/**
 *
 * @author Danielitto
 */
    private ArrayList<Usuario> usuarios;
    private ArrayList<Consultas> consultas;
    private ArrayList<Propiedades> propiedades;
    private ArrayList<Venta> ventas;

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
    

