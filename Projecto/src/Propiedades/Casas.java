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

    public Casas(int numPisos, int numHabitaciones, double precio, double ancho, double profundidad, Ubicacion ubicacion, Agentes agente, String codigo) {
        super(precio, ancho, profundidad, ubicacion, agente, codigo);
        this.numPisos = numPisos;
        this.numHabitaciones = numHabitaciones;
    }
  
    @Override
    public void mostrarInfoPropiedad(){
        System.out.println("Hola, usted ha elegido la propiedad numero "+getCodigo()+"\n Breve descripción: "+getDescripcion()+"\n Se encuentra ubicada en: "+getUbicacion().toString()
                +"\n Profundidad de:"+getProfundidad()+" m y Ancho de: "+getAncho()+" m"+"Cuenta con:\n"+"- "+numPisos+" pisos.\n - "
                +numHabitaciones+"Habitaciones."+"\n Se oferta a un precio de: "+getPrecio()+"\n El agente encargado de esta propiedad es:"+getAgente());
    }
}

