/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.services;

import com.example.controller.dao.TransaccionDao;
import com.example.models.Transaccion;
import com.example.controller.tda.list.LinkedList;

/**
 *
 * @author maria-chuico
 */

public class TransaccionServices {
    private TransaccionDao transaccionDao;

    public TransaccionServices() {
        transaccionDao = new TransaccionDao();
    }

    public void registrarTransaccion(Integer idProyecto, String descripcion) {
        Transaccion transaccion = new Transaccion(
            idProyecto, 
            descripcion);
        try {
            transaccionDao.save(transaccion); // Guarda la transacción en el dao
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }

    public LinkedList<Transaccion> listAllTransacciones() {
        return transaccionDao.getListAll();
    } 
}
