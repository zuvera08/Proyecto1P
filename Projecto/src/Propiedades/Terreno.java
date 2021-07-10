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
public class Terreno extends Propiedades {
     private String tipoTerreno;
       
       public Terreno(double precio,double ancho,double profundidad,Ubicacion ubicacion,Agentes agente,String codigo,String tipoTerreno){
           super(precio,ancho,profundidad,ubicacion,agente,codigo);
           this.tipoTerreno=tipoTerreno;
       }
       
       public String getTipoTerreno(){
           return tipoTerreno;
       }
       
       public void setTipoTerreno(String tipoTerreno){
           this.tipoTerreno=tipoTerreno;
       }
}
