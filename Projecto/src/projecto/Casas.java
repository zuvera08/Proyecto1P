/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

/**
 *
 * @author PC
 */
public class Casas extends Propiedades{
    private int numPisos;
    private int numHabitaciones;

    public Casas(int numPisos, int numHabitaciones, double precio, double ancho, double profundidad, Ubicacion ubicacion, Agentes agente, String codigo) {
        super(precio, ancho, profundidad, ubicacion, agente, codigo);
        this.numPisos = numPisos;
        this.numHabitaciones = numHabitaciones;
    }
    
}
