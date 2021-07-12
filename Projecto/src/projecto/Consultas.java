/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import java.time.LocalDateTime;

/**
     * La clase consultas es donde se alamacena las preguntas y respues entre clientes y agentes sobre una propiedad
     
     * @author JosueVera
     */
public class Consultas {
    private LocalDateTime fechaInicio;
    private String codigoPropiedad;
    private Agentes agente ;
    private Clientes cliente;
    private String pregunta;
    private boolean estado;
    private String respuesta;
    
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
    public Consultas(LocalDateTime fechaInicio, String codigoPropiedad, Agentes agente, Clientes cliente, String pregunta, boolean estado, String respuesta) {
        this.fechaInicio = fechaInicio;
        this.codigoPropiedad = codigoPropiedad;
        this.agente = agente;
        this.cliente = cliente;
        this.pregunta = pregunta;
        this.estado = estado;
        this.respuesta = respuesta;
    }

    
    public void registrarConsulta(Clientes cliente, String pregunta, String codigo){
        fechaInicio= LocalDateTime.now();
        this.cliente=cliente;
        this.pregunta=pregunta;
        estado=true;
        codigoPropiedad=codigo;
    
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public Agentes getAgente() {
        return agente;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    @Override
    public String toString(){
        return fechaInicio+"    "+codigoPropiedad+"    "+agente.getNombre()+"    "+pregunta+"    "+estado;
    }
}
