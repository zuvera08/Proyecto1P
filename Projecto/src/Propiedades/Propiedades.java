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
public class Propiedades {
   private double precio;
   private double tasa;
   private double ancho;
   private double profundidad;
   private Ubicacion ubicacion;
   private Agentes agente;
   private String codigo;
   private boolean vendida;
   
   
   public Propiedades(double precio,double ancho,double profundidad,Ubicacion ubicacion,Agentes agente,String codigo){
       this.precio=precio;
       this.ancho=ancho;
       this.profundidad=profundidad;
       this.ubicacion=ubicacion;
       this.agente=agente;
       this.codigo=codigo;
   }
   
   public double getPrecio(){
       return precio;
   }
   public double getTasa(){
       return tasa;
   }
   public double getAncho(){
       return ancho;
   }
   public double getProfundidad(){
       return profundidad;
   }
   public Ubicacion getUbicacion(){
       return ubicacion;
   }
   public Agentes getAgente(){
       return agente;
   }
   public String getCodigo(){
       return codigo;
   }
   public boolean getVendida(){
       return vendida;
   }
   
   public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   public void setAgente(Agentes agente) {
        this.agente = agente;
    }
   public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
   public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }
   public void setAncho(double ancho) {
        this.ancho = ancho;
    }
   public void setPrecio(double precio) {
        this.precio = precio;
    }
   public void setTasa(double tasa) {
        this.tasa = tasa;
    }
   public void setVendidad(boolean estado){
       vendida=estado;
   }
}
