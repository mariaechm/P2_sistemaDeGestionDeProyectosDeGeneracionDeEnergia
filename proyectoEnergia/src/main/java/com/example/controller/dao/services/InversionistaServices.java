package com.example.controller.dao.services;

import com.example.controller.dao.InversionistaDao;
import com.example.models.Inversionista;
import com.example.controller.tda.list.LinkedList;


public class InversionistaServices {
    private InversionistaDao obj;
    public InversionistaServices() {
        obj = new InversionistaDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public void update() throws Exception {
        obj.update();
    }

    public LinkedList<Inversionista> listAll(){
        return obj.getListAll();
    }

    public Inversionista getInversionista(){
        return obj.getInversionista();
    }

    public void setInversionista(Inversionista Inversionista) {
        obj.setInversionista(Inversionista);
    }

    public Inversionista get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void delete(Integer id) throws Exception {
        obj.deleteInversionista(id);
    } 
    
    public LinkedList order(Integer type_order, String atributo, Integer method)  throws Exception{
        return obj.order(type_order, atributo, method);
    }

    public Inversionista[] buscar (String atributo, String valor)  throws Exception{
        return obj.buscar(atributo, valor);
    }
}


