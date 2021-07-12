/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaria;
import Propiedades.Propiedades;
import java.lang.Math;
/**
 *Esta clase tiene la el procedimiento que se debe llevar acabo para el calculo de un prestamo de amortizacion francesa
 * @author Ricardo Siavichay
 */
public class PrestamoFrances extends CalculadoraPrestamo {
/**
     *Constructor para el prestamo Frances
     * @param propiedad aqui se ingresa la propiedad en la cual esta interesado el cliente
     * @param cuota aqui se ingresa el total de cuotas en las cuales el cliente desea pagar la propiedad
     **/
   public PrestamoFrances(Propiedades propiedad, int cuota) {
        super(propiedad, cuota, "Frances");
    }
 /**
     *Este metodo retorna el numero de cuotas que debe pagar por mes el cliente si decide una amortizacion francesa
     * @return double retorna la cantidad a pagar por cada cuota
     **/
    @Override
    public double calcularPrestamo() {
        double precio=getPropiedad().getPrecio();
        double interes=getPropiedad().getTasa();
        int cuotas=getCuota();
        double valorPorCuota=precio*(interes/(1-Math.pow((1+interes),cuotas)));
        return valorPorCuota;
    }
}
