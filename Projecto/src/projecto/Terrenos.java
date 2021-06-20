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
public class Terrenos extends Propiedades {
    private String tipoTerreno;

    public Terrenos(String tipoTerreno, double precio, double ancho, double profundidad, Ubicacion ubicacion, Agente agente, String codigo) {
        super(precio, ancho, profundidad, ubicacion, agente, codigo);
        this.tipoTerreno = tipoTerreno;
    }
    
}
