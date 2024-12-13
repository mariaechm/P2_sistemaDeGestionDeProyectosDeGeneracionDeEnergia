/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

/**
 * 
 * @autor maria-chuico
 */

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Inversionista;
import com.example.models.Proyecto;
import com.example.models.enumerator.TipoProyecto;

public class ProyectoDao extends AdapterDao<Proyecto> {
    private Proyecto proyecto;
    private LinkedList listAll;

    // Constructor de la clase que inicializa con DAO
    public ProyectoDao() {
        super(Proyecto.class);
    }

    public Proyecto getProyecto() {
        if (proyecto == null) {
            proyecto = new Proyecto();
        }
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    // Guardar un proyecto
    public Boolean save() throws Exception {
        Integer idProyecto = getListAll().getSize() + 1;
        proyecto.setId(idProyecto);
        this.persist(this.proyecto);
        this.listAll = listAll();
        return true;
    }

    //Obtener ID de un proyecto
    public Proyecto getById (Integer idProyecto) throws Exception {
        return this.get(idProyecto);
    }

    //Actualizar un proyecto
    public void update()throws Exception{
        Integer idProyecto = this.getProyecto().getId();
        merge(this.proyecto, idProyecto);
    }

    //Eliminar un proyecto
    public void deleteProyecto(Integer idProyecto) throws Exception {
        delete(idProyecto);
    
    }
    public LinkedList order(Integer type_order, String atributo, Integer method) throws Exception{
        LinkedList listita = listAll();
        if (method.equals(0)) {
            listita.quickSort(atributo, type_order);
        } else if (method.equals(1)) {
            listita.shellSort(atributo, type_order);
        } else if (method.equals(2)) {
            listita.mergeSort(atributo, type_order);
        }
        return listita;
    }

    public Proyecto [] buscar (String attribute, String valor) throws Exception{
        LinkedList<Proyecto> listita = listAll();
        return listita.busquedaLinealBinaria(attribute, valor).toArray();
    }

}