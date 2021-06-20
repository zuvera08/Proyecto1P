/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import projecto.Usuario.Agente;
import projecto.Usuario.Cliente;

/**
 *
 * @author Ricardo Siavichay
 */
public class Venta {
    private Propiedades propiedad;
    private String fecha;
    private Agentes agente;
    private Clientes cliente;
    public Venta(Propiedades p,String f, Agentes a, Clientes c){
        propiedad=p;
        fecha=f;
        agente=a;
        cliente=c;
    }
}
    