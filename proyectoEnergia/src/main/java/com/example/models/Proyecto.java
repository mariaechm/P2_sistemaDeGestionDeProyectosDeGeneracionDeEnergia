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
    private Integer idProyecto; //identificador unico   
    private String nombre; //nombre del proyecto
    private Float montoInversion; //monto de inversion
    private Integer tiempoDeVida;
    private String fechaInicio; //fecha de inicio
    private String fechaFin; //fecha final de construcucion
    private Float capacidadGeneracionPorDia; //capacidad de generacion en un dia
    private Float montoTotal; //monto total de inversion
    private TipoProyecto tipo; //solar, eolico, hidroelectrico, termoelectrico

    //Constructor
    public Proyecto(Integer idProyecto, String nombre, Float montoInversion, Integer tiempoDeVida, String fechaInicio, String fechaFin, Float capacidadGeneracionPorDia, Float montoTotal, TipoProyecto tipo) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.montoInversion = montoInversion;
        this.tiempoDeVida = tiempoDeVida;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidadGeneracionPorDia = capacidadGeneracionPorDia;
        this.montoTotal = montoTotal;
        this.tipo = tipo;
    }  
    
    //Getters y Setters
    public Integer getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
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

    public Float getCapacidadGeneracionPorDia() {
        return this.capacidadGeneracionPorDia;
    }

    public void setCapacidadGeneracionPorDia(Float capacidadGeneracionPorDia) {
        this.capacidadGeneracionPorDia = capacidadGeneracionPorDia;
    }

    public Float getMontoTotal() {
        return this.montoTotal;
    }

    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public TipoProyecto getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoProyecto tipo) {
        this.tipo = tipo;
    }

    // Constructor por defecto
    public Proyecto() {
    }
    
}
