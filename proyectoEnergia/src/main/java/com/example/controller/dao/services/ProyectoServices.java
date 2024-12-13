/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import com.example.controller.dao.ProyectoDao;
import com.example.models.Inversionista;
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

    public void update() throws Exception {
        obj.update();
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

    public void delete(Integer id) throws Exception {
        obj.deleteProyecto(id);
    } 
    
    public LinkedList order(Integer type_order, String atributo, Integer method)  throws Exception{
        return obj.order(type_order, atributo, method);
    }

    public Proyecto[] buscar (String atributo, String valor)  throws Exception{
        return obj.buscar(atributo, valor);
    }
}

