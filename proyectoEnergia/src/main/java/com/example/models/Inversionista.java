/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;
/**
 *
 * @author maria-chuico
 */

public class Inversionista {
    private Integer id; //identificador unico
    private String nombre; //nombre del inversionista
    private String apellido; //apellido del inversionista
    private String identificacion; //cedula, pasaporte, RUC 


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

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    /* public String toString(){
        return apellido + " " + nombre;
    } */
}

