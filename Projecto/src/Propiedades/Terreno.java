/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;
import projecto.Agentes;
/**
     *Esta clase representa a los terrenos que se encuentran dentro de la aplicacion
     * @author Ricardo Saivichay
     **/
public class Terreno extends Propiedades {
    private TiposTerreno tipoTerreno;
     /**
    *Constructor para un objeto de tipo propiedad y se establece su estado en no vendida
    * @param precio aqui se establece el precio que tendra la propiedad
    * @param ancho el ancho de la propiedad
    * @param profundidad la profundidad de la propiedad
    * @param ubicacion la ubicacion en que se encuentra
    * @param agente el agente encargado de la propiedad
    * @param codigo el codigo asociado a la propiedad
    * @param tasa se ingresa la tasa de interes para los pagos de la casa
    * @param tipoTerreno se ingresa el tipo de terreno
    **/
    public Terreno(double precio,double ancho,double profundidad,Ubicacion ubicacion,Agentes agente,String codigo,double tasa,TiposTerreno tipoTerreno){
        super(precio,ancho,profundidad,ubicacion,agente,codigo,tasa);
        this.tipoTerreno=tipoTerreno;
    }
       
    public TiposTerreno getTipoTerreno(){
        return tipoTerreno;
    }
       
    public void setTipoTerreno(TiposTerreno tipoTerreno){
        this.tipoTerreno=tipoTerreno;
    }
    
    /**
     *Se muestra la informacion del terreno
     **/
     @Override
    public void mostrarInfoPropiedad(){
        System.out.println("Hola, usted ha elegido la propiedad numero "+getCodigo()+"\n Breve descripción: "+getDescripcion()+"\n Se encuentra ubicada en: "+getUbicacion().toString()
                +"\n Profundidad de:"+getProfundidad()+" m y Ancho de: "+getAncho()+" m"+"Terreno de tipo: "+tipoTerreno+"\n Se oferta a un precio de: "+getPrecio()+"\n El agente encargado de esta propiedad es:"+getAgente());
    }
    @Override
    public String toString(){
        return "Hola, se ha registrado la propiedad numero "+getCodigo()+"\n Breve descripción: "+getDescripcion()+"\n Se encuentra ubicada en: "+getUbicacion().toString()
                +"\n Profundidad de:"+getProfundidad()+" m y Ancho de: "+getAncho()+" m"+"Terreno de tipo: "+tipoTerreno+"\n Se oferta a un precio de: "+getPrecio()+"\n El agente encargado de esta propiedad es:"+getAgente();
    }
}
