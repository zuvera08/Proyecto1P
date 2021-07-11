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
     private TiposTerreno tipoTerreno;
       
       public Terreno(double precio,double ancho,double profundidad,Ubicacion ubicacion,Agentes agente,String codigo,TiposTerreno tipoTerreno){
           super(precio,ancho,profundidad,ubicacion,agente,codigo);
           this.tipoTerreno=tipoTerreno;
       }
       
       public TiposTerreno getTipoTerreno(){
           return tipoTerreno;
       }
       
       public void setTipoTerreno(TiposTerreno tipoTerreno){
           this.tipoTerreno=tipoTerreno;
       }
}
