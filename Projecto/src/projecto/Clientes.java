/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import Propiedades.Casas;
import Propiedades.Propiedades;
import Propiedades.Terreno;
import Utilitaria.PrestamoAleman;
import Utilitaria.PrestamoFrances;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * SuperClase que sirve para la tener la informacion en comun que poseen los clientes, agentes y administradores de la aplicacion
 * @author Zuleyka Vera
 **/
public class Clientes extends Usuario {
    private LocalDate fechaNacimiento;
    private Alerta preferencias;
    private double prestamo;
    
    /**
    *Metodo que le da la opcion de salir al usuario de donde se encuentre
    * @param bd la base de datos donde se encuentre
    **/
    public void salir(BaseDatos bd) {
        Usuario u = new Usuario();
        u.iniciarMenu(bd);
    }
    /**
     *Metodo que sirve para mostrar las distintas opciones que poseen los clientes de la app
     **/
    public void opcionesCliente(BaseDatos bd) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.println("Elija una opcion :");
            System.out.println("CONSULTAR PROPIEDADES DISPONIBLES (1):");
            System.out.println("Consultar Buzon Consultas(2):");
            System.out.println("Crear Alerta (3):");
            System.out.println("Simular Prestamo (4)");
            opcion = sc.next();
            sc.nextLine();
            switch (opcion) {
                case "1":
                    
                    System.out.println("Ingrese el tipo de propiedad:");
                    String tipoPropiedad= sc.nextLine();
                    System.out.println("Ingrese el precio minimo:");
                    double precioMin= sc.nextInt();
                    System.out.println("Ingrese el precio maximo:");
                    double precioMax= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese la ciudad:");
                    String ciudad= sc.nextLine();
                    System.out.println("Ingrese el sector:");
                    String sector= sc.nextLine();
                    ArrayList<Propiedades> propiedadesDisponibles=consultarPropiedadesDisponibles(precioMin,precioMax, tipoPropiedad, ciudad, sector,bd) ;
                    System.out.println("   Código         Descripción         Precio      Tamaño         Ubicación          Consultada   ");
                    for (Propiedades p: propiedadesDisponibles){
                        for(Consultas c:bd.getConsulta()){
                            System.out.println(p.toString()+"   "+p.getUbicacion().toString()+"   "+c.propiedadConsultada(p));
                        }    
                    }
                    System.out.println("Ingrese el codigo de la propiedad que desea más a detalle ( o vacío para regresar):");
                    String detalle=sc.nextLine();
                    Propiedades propiedad=null;
                    if (detalle!=""){
                        for(Propiedades p:bd.getPropiedades()){
                            if(detalle.equals(p.getCodigo())){
                                p.mostrarInfoPropiedad();
                                propiedad=p;
                            }
                        }
                        System.out.println("Desea realizar consulta(si/no):");
                        String confirmacion=sc.nextLine().toLowerCase();
                        if("si".equals(confirmacion)){
                            System.out.println("Ingrese su consulta:");
                            String pregunta=sc.nextLine();
                            for(Usuario u:bd.getUsuarios()){
                                if(u instanceof Clientes){
                                    Clientes c=(Clientes)u;
                                    if(c.getCedula().equals(getCedula())){
                                        registrarConsulta(pregunta,propiedad,c);
                                    }
                                }
                            }
                        }else{
                            opcion="5";
                        }
                    }else{
                        opcion="5";
                    }
                    
                    break;
                case "2":
                    ConsultarBuzon(bd);
                    System.out.println("Ingrese el codigo de la propiedad que desea más a detalle ( o vacío para regresar):");
                    String detalle1=sc.nextLine();
                    if(detalle1!=""){
                        Propiedades propiedad1=null;
                        for(Propiedades p:bd.getPropiedades()){
                            if(detalle1.equals(p.getCodigo())){
                                propiedad=p; //se refiere a una propiedad en específico, que tiene un solo agente.
                                for(Consultas c:bd.getConsulta()){
                                    if(c.getCliente().getCedula().equals(getCedula())){ //Obtiene las consultas que ha hecho un cliente sobre una propiedad
                                        if(c.getRespuesta()!= null){
                                            System.out.println(c.getFechaInicio()+": Cliente:"+c.getPregunta());
                                            System.out.println(c.getFechaFin()+": Agente:"+c.getRespuesta());
                                        }else{
                                            System.out.println(c.getFechaInicio()+": Cliente:"+c.getPregunta());
                                            System.out.println("Lo sentimos, su pregunta aún no ha sido respondida");
                                        }
                                    }
                                    System.out.println("Usted no ha hecho consultas sobre esta propiedad");
                                }
                            }
                        }
                        System.out.println("Desea agregar una pregunta o regresar(si/no):");
                        String confirmacion1=sc.nextLine().toLowerCase();
                        if("si".equals(confirmacion1)){
                            System.out.println("Ingrese la pregunta:");
                            String pregunta1=sc.nextLine();
                            for(Usuario u:bd.getUsuarios()){
                                if(u instanceof Clientes){
                                    Clientes c=(Clientes)u;
                                    if(c.getCedula().equals(getCedula())){
                                        registrarConsulta(pregunta1,propiedad1,c);
                                    }
                                }
                            }
                        }else{
                            opcion="5";
                        }
                    }else{
                        opcion="5";
                    }
                    break;
                case "3":
                    CrearAlerta();
                    break;
                    
                case "4":
                    System.out.println("Ingrese el codigo de la propiedad deseada ");
                    String codigo= sc.nextLine();
                    bd.getPropiedades();
                    for(Propiedades p : bd.getPropiedades()){
                        if (p.getCodigo().equals(codigo)){
                            System.out.println("Ingrese la cuota deseada");
                            int cuota= sc.nextInt();
                            System.out.println("Ingrese la amortizacion deseada");
                            String amortizacion= sc.nextLine();
                            simularPrestamo(p,cuota,amortizacion);
                            break;
                        }
                    }
                   
                    default:
                    System.out.println("Opcion Incorrecta");
                break;
            }

        } while (!opcion.equals("5"));
        salir(bd);
    }
    public Clientes(LocalDate fechaNacimiento, Alerta preferencias, String usuario, String nombre, String cedula, String correo, String contrasenia) {
        super(usuario, nombre, cedula, correo, contrasenia);
        this.fechaNacimiento = fechaNacimiento;
        this.preferencias = preferencias;
    }
    
    /**
     *Metodo para mostrar cuales son las propiedades que se encuentran disponilbes en base a los parametros indicados
     * @param precioMin el precio minimo de busqueda
     * @param precioMax el precio maximo de busqueda
     * @param tipoPropiedad el tipo de propiedad que se esta buscando
     * @param ciudad la ciudad deseada
     * @param sector el sector deseado
     * @param bd la base de datos a usarse
     **/
    public ArrayList<Propiedades> consultarPropiedadesDisponibles(double precioMin, double precioMax, String tipoPropiedad, String ciudad, String sector,BaseDatos bd ){
        ArrayList<Propiedades> propiedadesDisponibles=new  ArrayList<>();
        for (Venta e: bd.getVentas()){
            switch (tipoPropiedad){
                case "casa":
                    if (e.getPropiedad() instanceof Casas){
                        Casas casa=(Casas)e.getPropiedad();
                        if(casa.getUbicacion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())){
                            if(casa.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }else{
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }
                        }else{
                            if(casa.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }else{
                                if(casa.getPrecio()>=precioMin && casa.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(casa);
                                }
                            }
                        }
                    }
                    
                    break;
                case "terreno":
                    if (e.getPropiedad() instanceof Terreno){
                        Terreno propiedad=(Terreno)e.getPropiedad();
                        if(propiedad.getUbicacion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())){
                            if(propiedad.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }else{
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }
                        }else{
                            if(propiedad.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }else{
                                if(propiedad.getPrecio()>=precioMin && propiedad.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(propiedad);
                                }
                            }
                        }
                    }
                    break;
                default:
                    Propiedades p=e.getPropiedad();
                    if(p.getUbicacion().getCiudad().toLowerCase().equals(ciudad.toLowerCase())){
                            if(p.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }else{
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }
                        }else{
                            if(p.getUbicacion().getSector().toLowerCase().equals(sector.toLowerCase())){
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }else{
                                if(p.getPrecio()>=precioMin && p.getPrecio()<=precioMax){
                                    propiedadesDisponibles.add(p);
                                }
                            }
                        }
                    }
                    
                }
        return propiedadesDisponibles;
        }
    /**
     * Este método permite registrar una consulta
     */
    public void registrarConsulta(String pregunta,Propiedades propiedad, Clientes cliente) {
        Consultas consulta=new Consultas(propiedad);
        consulta.setPregunta(pregunta);
        consulta.setCliente(cliente);
    }
    
    
    /**
     *Este metodo permite al cliente consultar su buzon de consultas
     **/
    public void ConsultarBuzon(BaseDatos bd){
        
        System.out.println("   Fecha Inicio   Código propiedad         Nombre Agente                      Pregunta                       Estado");
        for(Consultas a: bd.getConsulta()){
            if (a.getCliente().getNombre().equals(getNombre())&& a.getCliente().getCedula().equals(getCedula())&& a.getCliente().getUsuario().equals(getUsuario())){
                System.out.println(a.mostrarPreguntas());
            }
        }   
    }
    /**
     *Este metodo permite al cliente crear un objeto en alertas que le permita estar al tanto de cuando se abra una propiedad de sus preferencias
     **/
    public void CrearAlerta(){
        System.out.println("Ingrese sus preferencias: ");
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese precio Minimo: ");
        double precioMin=sc.nextDouble();
        System.out.println("Ingrese precio Maximo: ");
        double precioMax=sc.nextDouble();
        System.out.println("Ingrese tipo de propiedad que desea (terreno o casa): ");
        String tipoPropiedad=sc.nextLine().toLowerCase();
        System.out.println("Ingrese la ciudad de su preferencia: ");
        String ciudad=sc.nextLine().toLowerCase();
        System.out.println("Ingrese sector de su preferencia:" );
        String sector=sc.nextLine().toLowerCase();
        preferencias= new Alerta(tipoPropiedad, precioMin, precioMax, ciudad, sector);
    }
    /**
     * Este método envía un correo si se cumple con todas las exigencias y preferencias del cliente
     * @param p 
     */
    public void enviarCorreo(Propiedades p){
        String asunto;
        String mensaje;
        asunto="Se ha encontrado una propiedad que se ajusta a sus preferencias";
        switch (preferencias.getTipoPropiedad()){
            case "casa":
                if (p instanceof Casas){
                    Casas casa=(Casas)p;
                    if ((preferencias.getPrecioMin()>=casa.getPrecio()&& preferencias.getPrecioMax()<=casa.getPrecio())&&
                        preferencias.getCiudad().equals(casa.getUbicacion().getCiudad())&& preferencias.getSector().equals(casa.getUbicacion().getSector())){ 
                        mensaje=casa.toString();
                        correo(asunto,mensaje);
                    }
                }
                break;
            case "terreno":
                if (p instanceof Terreno){
                    Terreno terreno=(Terreno)p;
                    if ((preferencias.getPrecioMin()>=terreno.getPrecio()&& preferencias.getPrecioMax()<=terreno.getPrecio())&&
                        preferencias.getCiudad().equals(terreno.getUbicacion().getCiudad())&& preferencias.getSector().equals(terreno.getUbicacion().getSector())){
                        mensaje=terreno.toString();
                        correo(asunto,mensaje);
                    }   
                }
                break;
            default:
                
            
        }
       
    }
    /**
     * Este método permite enviar un correo
     * @param asunto
     * @param mensaje
     * @return boolean si se logró enviar el correo
     */
    public boolean correo(String asunto, String mensaje){
        try{
            Properties p= new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user","proyecto.poo1t@gmail.com");
            p.setProperty("mail.smtp.auth", "true");
            
            Session s =Session.getDefaultInstance(p,null);
            BodyPart texto= new MimeBodyPart();
            texto.setText(mensaje);
            MimeMultipart m= new MimeMultipart();
            m.addBodyPart(texto);
            MimeMessage mens= new MimeMessage(s);
            mens.setFrom(new InternetAddress("proyecto.poo1t@gmail.com"));
            mens.addRecipient(Message.RecipientType.TO, new InternetAddress(getCorreo()));
            mens.setSubject(asunto);
            mens.setContent(m);
            Transport t= s.getTransport("smtp");
            t.connect("proyecto.poo1t@gmail.com", "proyectopoo1");
            t.sendMessage(mens, mens.getAllRecipients());
            t.close();
            return true;
        } catch(MessagingException e){
            System.out.println("Error"+e);
            return false;
        }
        
    }
    /**
     *Este metodo sirve para que el usuario pueda saber cuanto es el valor de las coutas mensuales a pagar dependiendo del tipo de amorzacion que desee utilizar, en casa de ser alemana, se mostrara tambien cual es el valor del pago inicial que debe realziar
     *@param propiedad la propiedad de interes por el cliente
     * @param cuota la cantidad de coutas que desea realizar el cliente
     * @param amortizacion el tipo de prestamo que desea realzar el cliente
     **/
    
    public void simularPrestamo(Propiedades propiedad, int cuota, String amortizacion){
        if(amortizacion.toLowerCase().equals("frances")){
           PrestamoFrances calculof = new PrestamoFrances(propiedad,cuota);
           System.out.println("Cuoras: "+cuota+" --- "+"Valor de la cuota: "+calculof.calcularPrestamo() );
        }else if(amortizacion.toLowerCase().equals("aleman")){
           PrestamoAleman calculoa = new PrestamoAleman(propiedad,cuota);
           System.out.println("Cuoras: "+cuota+" --- "+"Valor de la cuota: "+calculoa.calcularPrestamo()+" --- "+"Valor incial a pagar: "+calculoa.getValorInicial() );
        }
    }
}
