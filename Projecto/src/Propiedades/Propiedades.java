/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;
import projecto.Agentes;
/**
 *Esta clase respresenta a la clase padre de las distinas propiedades que se encuentran a la venta, las cuales son terrenos y casas
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
    private String descripcion;
    private boolean vendida;
 /**
    *Constructor para un objeto de tipo propiedad y se establece su estado en no vendida
    * @param precio aqui se establece el precio que tendra la propiedad
    * @param ancho el ancho de la propiedad
    * @param profundidad la profundidad de la propiedad
    * @param ubicacion la ubicacion en que se encuentra
    * @param agente el agente encargado de la propiedad
    * @param codigo el codigo asociado a la propiedad
    * @param tasa se ingresa la tasa de interes para los pagos de la casa
    **/
    public Propiedades(double precio, double ancho, double profundidad, Ubicacion  ubicacion , Agentes  agente , String codigo,double tasa) {
        this.precio = precio;
        this.tasa = tasa;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.ubicacion= ubicacion;
        this.agente= agente;        
        this.codigo = codigo;
        vendida=false;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Agentes getAgente() {
        return agente;
    }

    public void setAgente(Agentes agente) {
        this.agente = agente;
    }

    public String getCodigo() {
        return codigo;
    }
   public boolean getVendida(){
       return vendida;
   }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double tama??o(){
        return ancho*profundidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
  
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }
    public void setVendidad(boolean estado){
        vendida=estado;
    }

    public double getTasa() {
        return tasa;
    }

    public boolean isVendida() {
        return vendida;
    }
    
    @Override
    public String toString(){
        return " "+codigo+"    "+descripcion+"    "+precio+"   "+tama??o()+"m2";
    }
    public void mostrarInfoPropiedad(){
        System.out.println("Hola, usted ha elegido la propiedad numero "+codigo+"\n Breve descripci??n: "+descripcion+"\n Se encuentra ubicada en: "+ubicacion.toString()
                +"\n Profundidad de:"+profundidad+" m y Ancho de: "+ancho+" m"+"\n Se oferta a un precio de: "+precio+"\n El agente encargado de esta propiedad es:"+agente);
    }
}
