/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;
import com.example.models.enumerator.TipoProyecto;
/**
 *
 * @author maria-chuico
 */
public class Proyecto {
    private Integer id; //identificador unico   
    private String nombre; //nombre del proyecto
    private Float montoInversion; //monto de inversion
    private Integer tiempoDeVida; //tiempo de vida del proyecto
    private String fechaInicio; //fecha de inicio
    private String fechaFin; //fecha final de construcucion
    private TipoProyecto tipo; //solar, eolico, hidroelectrico

    //Getters y Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getMontoInversion() {
        return this.montoInversion;
    }

    public void setMontoInversion(Float montoInversion) {
        this.montoInversion = montoInversion;
    }

    public Integer getTiempoDeVida() {
        return this.tiempoDeVida;
    }

    public void setTiempoDeVida(Integer tiempoDeVida) {
        this.tiempoDeVida = tiempoDeVida;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TipoProyecto getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoProyecto tipo) {
        this.tipo = tipo;
    }
    
}
