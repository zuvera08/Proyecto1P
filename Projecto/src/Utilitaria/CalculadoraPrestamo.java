/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaria;
import Propiedades.Propiedades;

/**
 *
 * @author Ricardo Siavichay
 */

 public abstract class CalculadoraPrestamo {
    private Propiedades propiedad;
    private int cuota;
    private String amortizacion;

    public CalculadoraPrestamo(Propiedades propiedad, int cuota, String amortizacion) {
        this.propiedad = propiedad;
        this.cuota = cuota;
        this.amortizacion = amortizacion;
    }

    
    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public String getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(String amortizacion) {
        this.amortizacion = amortizacion;
    }

    public abstract double calcularPrestamo();

}
