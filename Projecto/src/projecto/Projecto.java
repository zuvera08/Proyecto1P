/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.ArrayList;
import projecto.Usuario.Administrador;
import projecto.Usuario.Agente;
import projecto.Usuario.Cliente;

/**
 *
 * @author Danielitto
 */
public class Projecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Propiedades> propiedades = new ArrayList<>();
        ArrayList<Consultas> consultas = new ArrayList<>();
        ArrayList<Venta> ventas = new ArrayList<>();
        Cliente cliente1 = new Cliente("A","A","A","A","A");
        Agente agente1 = new Agente();
        Agente agente2 = new Agente()
        Administrador admin1 = new Administrador();
        Administrador admin2 = new Administrador();
        Administrador admin3 = new Administrador();
        Casa casa1 = new Casa();
        Casa casa2 = new Casa();
        Terreno terreno1 = new Terreno();
        Terreno terreno2 = new Terreno();
        usuarios.add(cliente1);
        usuarios.add(agente1);
        usuarios.add(agente2);
        usuarios.add(admin1);
        usuarios.add(admin2);
        usuarios.add(admin3);
        propiedades.add(casa1);
        propiedades.add(casa2);
        propiedades.add(terreno1);
        propiedades.add(terreno2);  
    }
    
}
