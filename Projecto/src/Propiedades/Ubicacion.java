/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

/**
 *Esta clase almacena la informacion de la ubicacion de las propiedades
 * @author Ricardo Siavichay
 */
public class Ubicacion {
  private String provincia;
    private String ciudad;
    private String direccion;
    private String sector;
    /**
     *Este contructor es para la ubicacion
     * @param provincia la provincia de la propiedad
     * @param ciudad la ciudad en que se encuentra
     * @param direccion la direccion domiciliaria
     * @param sector el sector de ubicacion
     **/
    public Ubicacion(String provincia,String ciudad,String direccion,String sector){
        this.provincia=provincia;
        this.ciudad=ciudad;
        this.direccion=direccion;
        this.sector=sector;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    @Override
    public String toString(){
       return provincia+", "+ciudad+", "+direccion+", "+sector; 
    }
}
