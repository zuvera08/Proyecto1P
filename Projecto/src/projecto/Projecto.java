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
        BaseDatos datos= new BaseDatos() ;
        Usuario usuario= new Usuario();
        Usuario usuario1= new Administradores("ADMIN1","Guillermo", "0983805499","guiller@hotmail.com","Spiderman1400");
        datos.getUsuarios().add(usuario1);
        
        Usuario usuario2= new Agentes("007", "Agente007", "Luque", "0983805419", "luque@hotmail.com", "Spiderman2400");
        datos.getUsuarios().add(usuario2);
        
        Usuario usuario3= new Agentes("009", "Agente009", "Zack", "0983805432", "zack@hotmail.com", "Zack2400");
        datos.getUsuarios().add(usuario3);
        
        
        ArrayList <String> a= new ArrayList <> ();
        Usuario usuario4= new Clientes(LocalDate.parse("2001-09-01"),a,"Venededor16","Pepe","201914959","pepitoindustries@hotmail.com","Spiderman3400");
        datos.getUsuarios().add(usuario4);
        
        Ubicacion ubicacionpropiedades1= new Ubicacion("GUAYAS","GUAYAQUIL","SAUCES 4","IZQUIERDA");
        
        Propiedades propiedadesventas1= new Propiedades(4,3,2,ubicacionpropiedades1,(Agentes)usuario2,"ABC");
        datos.getPropiedades().add(propiedadesventas1);
        
        Venta venta1= new Venta(propiedadesventas1,LocalDate.parse("2019-12-12"),(Agentes)usuario2,(Clientes)usuario3);
        datos.getVentas().add(venta1);
        
        Usuario usuario5= new Clientes(LocalDate.parse("2001-10-02"),a,"Venededor17","Pepex","201914964","pepitoxindustries@hotmail.com","Spiderman4400");
        datos.getUsuarios().add(usuario5);
        
        Ubicacion ubicacionpropiedades2= new Ubicacion("GUAYAS","GUAYASQUIL","SAUCES 4","IZQUIERDA");
        Propiedades propiedadesventas2= new Propiedades(3,3,3,ubicacionpropiedades2,(Agentes)usuario2,"CBA");
        datos.getPropiedades().add(propiedadesventas2) ;
        
        Venta venta2= new Venta(propiedadesventas2,LocalDate.parse("2020-12-12"),(Agentes)usuario3,(Clientes)usuario4);
        datos.getVentas().add(venta2);
        
        Ubicacion ubicacionpropiedades3= new Ubicacion("GUAYAS","DAULE","DAULE","DERECHA");
        Propiedades propiedadesventas3= new Propiedades(5,7,8,ubicacionpropiedades3,(Agentes)usuario2,"ABC");
        datos.getPropiedades().add(propiedadesventas3);
        
        Ubicacion ubicacionpropiedades4= new Ubicacion("GUAYAS","DAULE","DAULE","DERECHA");
        
       Propiedades propiedadesventas4= new Propiedades(5,6,7,ubicacionpropiedades4,(Agentes)usuario3,"ABC");
        datos.getPropiedades().add(propiedadesventas4);
        
        usuario.iniciarMenu(datos);
        // TODO code application logic here
        
        /*Clientes cliente1 = new Clientes("A","A","A","A","A");
        Agentes agente1 = new Agentes();
        Agentes agente2 = new Agentes()
        Administradores admin1 = new Administradorse();
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
