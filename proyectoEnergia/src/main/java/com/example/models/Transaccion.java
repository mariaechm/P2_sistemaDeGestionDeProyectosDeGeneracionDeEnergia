/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

/**
 *
 * @author maria-chuico
 */
public class Transaccion {
    public Integer idTransaccion; //identificador unico
    public Integer idProyecto; //identificador unico
    public String descripcion;

    //Constructor
    public Transaccion(Integer idProyecto, String descripcion) {
        //this.idTransaccion = idTransaccion;
        this.idProyecto = idProyecto;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public Integer getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // Constructor por defecto
    public Transaccion() {
    }
}
