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
       private double numPisos;
       private int numHabitaciones;
       
       public Casas(double precio,double ancho,double profundidad,Ubicacion ubicacion,Agentes agente,String codigo,double numPisos,int numHabitaciones){
           super(precio,ancho,profundidad,ubicacion,agente,codigo);
           this.numPisos=numPisos;
           this.numHabitaciones=numHabitaciones;
       }
       
       public double getNumPisos(){
           return numPisos;
       }
       public double getNumHabitaciones(){
           return numHabitaciones;
       }
       
       public void setNumPisos(double numPisos){
           this.numPisos=numPisos;
       }
       public void setNumHabitaciones(int numHabitaciones){
           this.numHabitaciones=numHabitaciones;
       }
}

