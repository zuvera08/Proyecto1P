/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaria;
import Propiedades.Propiedades;
import java.lang.Math;

/**
 *
 * @author PC
 */
public class PrestamoAleman extends CalculadoraPrestamo{

    private double valorInicial;

    public PrestamoAleman(Propiedades propiedad, int cuota) {
        super(propiedad, cuota, "Aleman");
    }
    
    public double getValorInicial(){
        return valorInicial;
    }
    
    public void setValorInicial(double valor){
        valorInicial=valor;
    }
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
