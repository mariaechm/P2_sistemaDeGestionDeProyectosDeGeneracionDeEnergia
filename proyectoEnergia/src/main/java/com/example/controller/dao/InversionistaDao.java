/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.models.Inversionista;
import com.example.controller.tda.list.LinkedList;

/**
 *
 * @author maria-chuico
 */
public class InversionistaDao extends AdapterDao<Inversionista> {
    private Inversionista inversionista;
    private LinkedList listAll;

    public InversionistaDao(){
        super(Inversionista.class);
    }
    //Constructor de la clase que inicializa con DAO
    public Inversionista getInversionista() {
        if (inversionista == null) {
            inversionista = new Inversionista();
        }
        return this.inversionista;
    }

    //Asigna un objeto Inversionista al atributo interno    
    public void setInversionista(Inversionista inversionista) {
        this.inversionista = inversionista;
    }

    // Retorna la lista de los inversionistas
    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    //Guardar un inversionista
    public Boolean save() throws Exception{
        Integer id = getListAll().getSize()+1;
        inversionista.setId(id);
        this.persist(this.inversionista);
        this.listAll = listAll();
        return true;
    }

    //Actualiza Proyecto
    public Boolean update() throws Exception {
        this.merge(getInversionista(),getInversionista().getId());
        this.listAll = listAll();
        return true;
    }

    public void deleteInversionista(Integer idInversionista) throws Exception{
        delete(idInversionista);
    }

    public Inversionista getById(Integer idInversionista) throws Exception{
        return get(idInversionista);
    }
    

        //ordenamiento general
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

    //busca por cualquier atributte
    public Inversionista [] buscar (String attribute, String valor) throws Exception{
        LinkedList<Inversionista> listita = listAll();
        return listita.busquedaLinealBinaria(attribute, valor).toArray();
    }
}