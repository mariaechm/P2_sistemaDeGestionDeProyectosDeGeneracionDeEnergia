/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import com.example.controller.dao.ProyectoDao;
import com.example.models.Proyecto;
import com.example.controller.tda.list.LinkedList;

/**
 *
 * @author maria-chuico
 */

public class ProyectoServices {
    private ProyectoDao obj;
    public ProyectoServices() {
        obj = new ProyectoDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList<Proyecto> listAll(){
        return obj.getListAll();
    }

    public Proyecto getProyecto(){
        return obj.getProyecto();
    }

    public void setProyecto(Proyecto proyecto) {
        obj.setProyecto(proyecto);
    }

    public Proyecto get(Integer id) throws Exception {
        return obj.get(id);
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id);
    } 
    
    public LinkedList order(Integer type_order, String atributo) {
        return obj.order(type_order, atributo);
    }

    public LinkedList order_object(Integer type, String atributo) throws Exception {
        return obj.listAll().order(atributo, type);
    }

    public LinkedList<Proyecto> buscarPorNombre(String texto) {
        return obj.buscarPorNombre(texto);
    }
    /*public Persona buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }*/
}

