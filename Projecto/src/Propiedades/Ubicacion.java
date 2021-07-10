/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

/**
 *
 * @author Ricardo Siavichay
 */
public class Ubicacion {
  private String provincia;
    private String ciudad;
    private String direccion;
    private String sector;
    
    public Ubicacion(String provincia,String ciudad,String direccion,String sector){
        this.provincia=provincia;
        this.ciudad=ciudad;
        this.direccion=direccion;
        this.sector=sector;
    }
    
    public String getProvincia(){
        return provincia;
    }
    public String getCiudad(){
        return ciudad;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getSector(){
        return sector;
    }  
}
