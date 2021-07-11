/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.util.ArrayList;
import Propiedades.Propiedades;
import Propiedades.Ubicacion;
import java.time.LocalDate;
//import projecto.Usuario.Administrador;
//import projecto.Usuario.Agente;
//import projecto.Usuario.Cliente;

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
        BaseDatos datos= new BaseDatos() ;
        Usuario usuario= new Usuario();
        Usuario usuario1= new Administradores("ADMIN1","Guillermo", "0983805499","guiller@hotmail.com","Spiderman1400");
        datos.getUsuarios().add(usuario1);
        
        Usuario usuario2= new Agentes("007", "Agente007", "LUQUE", "0983805419", "luque@hotmail.com", "Spiderman2400");
        datos.getUsuarios().add(usuario2);
        
        ArrayList <String> a= new ArrayList <> ();
        Usuario usuario3= new Clientes(LocalDate.parse("2001-09-01"),a,"Venededor16","Pepe","201914959","pepitoindustries@hotmail.com","Spiderman3400");
        datos.getUsuarios().add(usuario3);
        
        Ubicacion ubicacionpropiedades1= new Ubicacion("GUAYAS","GUAYAS1","GUAYAS2","GUAYAS3");
        
        Propiedades propiedadesventas1= new Propiedades(4,3,2,ubicacionpropiedades1,(Agentes)usuario2,"ABC");
        datos.getPropiedades().add(propiedadesventas1);
        
        Venta venta1= new Venta(propiedadesventas1,LocalDate.parse("2019-12-12"),(Agentes)usuario2,(Clientes)usuario3);
        datos.getVentas().add(venta1);
        
        Usuario usuario4= new Clientes(LocalDate.parse("2001-10-02"),a,"Venededor17","Pepex","201914964","pepitoxindustries@hotmail.com","Spiderman4400");
        datos.getUsuarios().add(usuario4);
        
        Ubicacion ubicacionpropiedades2= new Ubicacion("GUAYASsssssss","GUAYAS1sssssssss","GUAYASsssss2","GUAYAS3ssss");
        Propiedades propiedadesventas2= new Propiedades(3,3,3,ubicacionpropiedades2,(Agentes)usuario2,"CBA");
        datos.getPropiedades().add(propiedadesventas2) ;
        
        Venta venta2= new Venta(propiedadesventas2,LocalDate.parse("2020-12-12"),(Agentes)usuario2,(Clientes)usuario4);
        datos.getVentas().add(venta2);
        
        usuario.iniciarMenu(datos);
        /*Clientes cliente1 = new Clientes("A","A","A","A","A");
        Agentes agente1 = new Agentes();
        Agentes agente2 = new Agentes()
        Administradores admin1 = new Administradores();
        Administradores admin2 = new Administradores();
        Administradores admin3 = new Administradores();
        Casas casa1 = new Casas();
        Casas casa2 = new Casas();
        Terrenos terreno1 = new Terrenos();
        Terrenos terreno2 = new Terrenos();
        usuarios.add(cliente1);
        usuarios.add(agente1);
        usuarios.add(agente2);
        usuarios.add(admin1);
        usuarios.add(admin2);
        usuarios.add(admin3);
        propiedades.add(casa1);
        propiedades.add(casa2);
        propiedades.add(terreno1);
        propiedades.add(terreno2);  */
    }
    
}
