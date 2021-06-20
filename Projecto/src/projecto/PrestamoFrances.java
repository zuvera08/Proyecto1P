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
public class PrestamoFrances extends CalculadoraPrestamo {

    public PrestamoFrances(Propiedades propiedad, double tasa, int cuota, double amortizacion) {
        super(propiedad, tasa, cuota, amortizacion);
    }

    @Override
    public double calcularPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
