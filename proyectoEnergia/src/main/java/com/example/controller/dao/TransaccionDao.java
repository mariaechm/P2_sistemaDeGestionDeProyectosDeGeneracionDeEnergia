/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.models.Transaccion;
import com.example.controller.tda.list.LinkedList;

/**
 *
 * @author maria-chuico
 */
public class TransaccionDao extends AdapterDao<Transaccion> {
    private LinkedList<Transaccion> listAll;
    
    public TransaccionDao() {
        super(Transaccion.class);
    }

    public LinkedList<Transaccion> getListAll() {
        if (this.listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save(Transaccion transaccion) throws Exception {
        // Genera el ID y lo asigna a la transacción antes de guardarla
        Integer id = getListAll().getSize() + 1; // Suponiendo que este ID sea secuencial
        transaccion.setIdTransaccion(id);
        persist(transaccion); 
        return true;
    }
    
}
