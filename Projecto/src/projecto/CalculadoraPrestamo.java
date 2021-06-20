package projecto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danielitto
 */
public abstract class CalculadoraPrestamo {
    private Propiedades propiedad;
    private double tasa;
    private int cuota;
    private double amortizacion;

    public CalculadoraPrestamo(Propiedades propiedad, double tasa, int cuota, double amortizacion) {
        this.propiedad = propiedad;
        this.tasa = tasa;
        this.cuota = cuota;
        this.amortizacion = amortizacion;
    }

    
    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public abstract double calcularPrestamo();

}
