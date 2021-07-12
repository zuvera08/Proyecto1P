/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaria;
import Propiedades.Propiedades;
import java.lang.Math;

/**
 *Esta clase tiene la el procedimiento que se debe llevar acabo para el calculo de un prestamo de amortizacion alemana
 * @author Ricardo Siavichay
 */
public class PrestamoAleman extends CalculadoraPrestamo{

    private double valorInicial;

   /**
     *Constructor para el prestamo Aleman
     * @param propiedad aqui se ingresa la propiedad en la cual esta interesado el cliente
     * @param cuota aqui se ingresa el total de cuotas en las cuales el cliente desea pagar la propiedad
     **/
    public PrestamoAleman(Propiedades propiedad, int cuota) {
        super(propiedad, cuota, "Aleman");
    }
    
    /**
    *Metodo para obtener el valor incial que debe pagar el cliente que desea comprar la propiedad por el metodo aleman
    *@return double retorna el valor del primer pago
    **/
    public double getValorInicial(){
        return valorInicial;
    }
    
    /**
    *Metodo para modificar el valor incial que debe pagar el cliente que desea comprar la propiedad por el metodo aleman
    *@param valor aqui se ingresa el valor que se quiere establecer como valor inicial de pago
    **/
    public void setValorInicial(double valor){
        valorInicial=valor;
    }

    /**
     *Este metodo retorna el numero de cuotas que debe pagar por mes el cliente si decide una amortizacion alemana
     * @return double retorna la cantidad a pagar por cada cuota
     **/
    @Override
    public double calcularPrestamo() {
        double precio=getPropiedad().getPrecio();
        double interes=getPropiedad().getTasa();
        int cuotas=getCuota();
        setValorInicial(precio*interes);
        double valorPorCuota=precio*(interes/(1-Math.pow((1-interes),cuotas)));
        return valorPorCuota;
    }
}
