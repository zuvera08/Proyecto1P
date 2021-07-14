/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import Propiedades.Propiedades;
import java.time.LocalDateTime;

/**
     * La clase consultas es donde se alamacena las preguntas y respues entre clientes y agentes sobre una propiedad
     
     * @author JosueVera
     */
public class Consultas {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Clientes cliente;
    private String pregunta;
    private boolean estadoRespuesta; //si se ha respondido o está en espera de una respuesta
    private boolean estadoConsulta; //si ya ha consultado o no sobre la proiedad
    private String respuesta;
    private Propiedades propiedad;
    
    /**
     * El constructor Consultas  inicializa las variables
     * @param  fechaInicio
     *  @param  Propieadad
     *  @param  Agente
     *  @param  CLiente
     *  @param  Pregunta
     *  @param  Estado
     *  @param  Respuesta
     * @author JosueVera
     */


    
    public Consultas(Propiedades propiedad){
        fechaInicio= LocalDateTime.now();
        fechaFin=null;
        cliente=null;
        pregunta=null;
        estadoRespuesta=false;
        estadoConsulta=true;
        respuesta = null;
        this.propiedad = propiedad;
        
    
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isEstadoRespuesta() {
        return estadoRespuesta;
    }

    public void setEstadoRespuesta(boolean estadoRespuesta) {
        this.estadoRespuesta = estadoRespuesta;
    }

    public boolean isEstadoConsulta() {
        return estadoConsulta;
    }

    public void setEstadoConsulta(boolean estadoConsulta) {
        this.estadoConsulta = estadoConsulta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    
    public String mostrarPreguntas(){
        if (estadoRespuesta==true){
            return fechaInicio+"    "+propiedad.getCodigo()+"    "+propiedad.getAgente().getNombre()+"    "+pregunta+"    "+"Respondido";
        }
        return fechaInicio+"    "+propiedad.getCodigo()+"    "+propiedad.getAgente().getNombre()+"    "+pregunta+"    "+"Esperando";
        
    }
    public String propiedadConsultada(Propiedades p){
        if(propiedad.equals(p)&&estadoConsulta==true){
            return "SI";
        }
        return "NO";
    }
}
