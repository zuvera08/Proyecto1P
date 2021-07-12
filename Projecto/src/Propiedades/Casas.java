/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;
import projecto.Agentes;
/**
 *
 * @author Ricardo Siavichay
 */
public class Casas extends Propiedades{
        private int numPisos;
    private int numHabitaciones;
/**
    *Constructor para un objeto de tipo propiedad y se establece su estado en no vendida
    * @param numPisos aqui se debe ingresar el numero de pisos que posee la casa
    * @param numHabitaciones aqui se debe ingresar el numero de habitaciones que posee la casa
    * @param precio aqui se establece el precio que tendra la propiedad
    * @param ancho el ancho de la propiedad
    * @param profundidad la profundidad de la propiedad
    * @param ubicacion la ubicacion en que se encuentra
    * @param agente el agente encargado de la propiedad
    * @param codigo el codigo asociado a la propiedad
    * @param tasa se ingresa la tasa de interes para los pagos de la casa
    **/
    public Casas(int numPisos, int numHabitaciones, double precio, double ancho, double profundidad, Ubicacion ubicacion, Agentes agente, String codigo,double tasa) {
        super(precio, ancho, profundidad, ubicacion, agente, codigo,tasa);
        this.numPisos = numPisos;
        this.numHabitaciones = numHabitaciones;
    }
    
    /**
     *Se muestra la informacion de la casa
     **/
    @Override
    public void mostrarInfoPropiedad(){
        System.out.println("Hola, usted ha elegido la propiedad numero "+getCodigo()+"\n Breve descripción: "+getDescripcion()+"\n Se encuentra ubicada en: "+getUbicacion().toString()
                +"\n Profundidad de:"+getProfundidad()+" m y Ancho de: "+getAncho()+" m"+"Cuenta con:\n"+"- "+numPisos+" pisos.\n - "
                +numHabitaciones+"Habitaciones."+"\n Se oferta a un precio de: "+getPrecio()+"\n El agente encargado de esta propiedad es:"+getAgente());
    }
       @Override
    public String toString(){
        return "Hola, se ha registrado la propiedad numero "+getCodigo()+"\n Breve descripción: "+getDescripcion()+"\n Se encuentra ubicada en: "+getUbicacion().toString()
                +"\n Profundidad de:"+getProfundidad()+" m y Ancho de: "+getAncho()+" m"+"Cuenta con:\n"+"- "+numPisos+" pisos.\n - "
                +numHabitaciones+"Habitaciones."+"\n Se oferta a un precio de: "+getPrecio()+"\n El agente encargado de esta propiedad es:"+getAgente();
    }
}

