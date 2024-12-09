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
import com.example.models.Proyecto;
import com.example.models.enumerator.TipoProyecto;

public class ProyectoDao extends AdapterDao<Proyecto> {
    private Proyecto proyecto;
    private LinkedList<Proyecto> listAll;

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

    public LinkedList<Proyecto> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        proyecto.setIdProyecto(id);
        this.persist(this.proyecto);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(getProyecto(), getProyecto().getIdProyecto() - 1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(Integer id) throws Exception {
        for (int i = 0; i < getListAll().getSize(); i++) {
            Proyecto pro = getListAll().get(i);
            if (pro.getIdProyecto().equals(id)) {
                getListAll().delete(i);
                return true;
            }
        }
        throw new Exception("No se encontró el proyecto");
    }

    public TipoProyecto getTipoProyecto(String tipo) {
        return TipoProyecto.valueOf(tipo);
    }

    public TipoProyecto[] getTipos() {
        return TipoProyecto.values();
    }

    // Método para ordenar proyectos de acuerdo a un atributo y tipo de orden
    public LinkedList<Proyecto> order(Integer type_order, String atributo) {
        LinkedList<Proyecto> listita = listAll();
        if (!listita.isEmpty()) {
            Proyecto[] lista = (Proyecto[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Proyecto aux = lista[i]; // valor a ordenar
                int j = i - 1; // índice anterior
                while (j >= 0 && (verify(lista[j], aux, type_order, atributo))) {
                    lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                }
                lista[j + 1] = aux; // inserta el valor en su posición correcta
            }

            // Convertir el array ordenado nuevamente a la lista
            listita.reset();
            for (int i = 0; i < lista.length; i++) {
                listita.add(lista[i]);
            }
        }
        return listita;
    }

    // Método de comparación 
    private Boolean verify(Proyecto a, Proyecto b, Integer type_order, String atributo) {
        if (type_order == 1) { // Orden ascendente
            if (atributo.equalsIgnoreCase("idProyecto")) {
                return a.getIdProyecto() > b.getIdProyecto();
            } else if (atributo.equalsIgnoreCase("nombre")) {
                return a.getNombre().compareTo(b.getNombre()) > 0;
            }
        } else { // Orden descendente
            if (atributo.equalsIgnoreCase("idProyecto")) {
                return a.getIdProyecto() < b.getIdProyecto();
            } else if (atributo.equalsIgnoreCase("nombre")) {
                return a.getNombre().compareTo(b.getNombre()) < 0;
            }
        }
        return false;
    }

    public LinkedList<Proyecto> buscarPorNombre(String nombre) {
        LinkedList<Proyecto> lista = new LinkedList<>();
        LinkedList<Proyecto> listita = listAll();
        if (!listita.isEmpty()) {
            Proyecto[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getNombre().toLowerCase().startsWith(nombre.toLowerCase())) {
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

}
