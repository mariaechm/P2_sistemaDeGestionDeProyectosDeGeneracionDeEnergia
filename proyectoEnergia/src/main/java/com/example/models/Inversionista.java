/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

import java.io.Serializable;
/**
 *
 * @author maria-chuico
 */

public class Inversionista {
    private Integer idInversionista; //identificador unico
    private String nombre; //nombre del inversionista
    private String apellido; //apellido del inversionista
    private String nacionalidad;
    private String identificacion; //cedula, pasaporte, RUC 

    //Constructor
    public Inversionista(Integer idInversionista, String nombre, String apellido, String nacionalidad, String identificacion) {
        this.idInversionista = idInversionista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.identificacion = identificacion;
    }

    //Getters y Setters
    public Integer getIdInversionista() {
        return this.idInversionista;
    }

    public void setIdInversionista(Integer idInversionista) {
        this.idInversionista = idInversionista;
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

    public String getNacionalidad() {
        return this.nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public String toString(){
        return apellido + " " + nombre;
    }

    // Constructor por defecto
    public Inversionista() {
    }
}
