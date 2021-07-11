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
    private String fecha;
    private Agentes agente;
    private Clientes cliente;

    public Venta(Propiedades propiedad, String fecha, Agentes agente, Clientes cliente) {
        this.propiedad = propiedad;
        this.fecha = fecha;
        this.agente = agente;
        this.cliente = cliente;
    }
    
    

    public String getFecha() {
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
    
}
    