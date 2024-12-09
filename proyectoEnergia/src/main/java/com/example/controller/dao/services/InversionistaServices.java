/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.controller.dao.services;

import com.example.controller.dao.InversionistaDao;
import com.example.models.Inversionista;
import com.example.controller.tda.list.LinkedList;
/**
 *
 * @author maria-chuico
 */
public class InversionistaServices {
    private InversionistaDao obj;
    public InversionistaServices(){
        obj = new InversionistaDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }
    
    public LinkedList<Inversionista> listAll(){
        return obj.getListAll();
    }

    public Inversionista getInversionista(){
        return obj.getInversionista();
    }

    public void setInversionista(Inversionista inversionista) {
        obj.setInversionista(inversionista);
    }

    public Inversionista get(Integer id) throws Exception {
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

    public LinkedList<Inversionista> buscarPorapellido(String texto) {
        return obj.buscarPorapellido(texto);
    }
    public Inversionista buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
}
