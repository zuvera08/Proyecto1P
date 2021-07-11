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
    public Venta(Propiedades p,LocalDate f, Agentes a, Clientes c){
        propiedad=p;
        fecha=f;
        agente=a;
        cliente=c;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Agentes getAgente() {
        return agente;
    }

    public void setAgente(Agentes agente) {
        this.agente = agente;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
}
    