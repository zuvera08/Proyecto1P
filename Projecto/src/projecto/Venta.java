/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import Propiedades.Propiedades;
import java.time.LocalDate;

/**
 *
 * @author Ricardo Siavichay
 */
public class Venta {
    private Propiedades propiedad;
    private LocalDate fecha;
    private Agentes agente;
    private Clientes cliente;

    public Venta(Propiedades propiedad, LocalDate fecha, Agentes agente, Clientes cliente) {
        this.propiedad = propiedad;
        this.fecha = fecha;
        this.agente = agente;
        this.cliente = cliente;
    }
    
    

    public LocalDate getFecha() {
        return fecha;
    }

    public Agentes getAgente() {
        return agente;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    @Override
    public String toString() {
        return "Venta{" + "propiedad=" + propiedad + ", fecha=" + fecha + ", agente=" + agente + ", cliente=" + cliente + '}';
    }
    
}
    