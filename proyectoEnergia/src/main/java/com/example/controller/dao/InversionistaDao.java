/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

import java.util.function.ToIntBiFunction;

import com.example.controller.dao.implement.AdapterDao;
import com.example.models.Inversionista;
import com.example.controller.tda.list.LinkedList;

/**
 *
 * @author maria-chuico
 */
public class InversionistaDao extends AdapterDao<Inversionista> {
    private Inversionista inversionista;
    private LinkedList<Inversionista> listAll;

    public InversionistaDao(){
        super(Inversionista.class);
    }
    
    public Inversionista getInversionista() {
        if (inversionista == null) {
            inversionista = new Inversionista();
        }
        return this.inversionista;
    }

    public void setInversionista(Inversionista inversionista) {
        this.inversionista = inversionista;
    }

    public LinkedList <Inversionista> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return this.listAll;
    }

    public Boolean save() throws Exception{
        Integer id = getListAll().getSize()+1;
        inversionista.setIdInversionista(id);
        this.persist(this.inversionista);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception{
        this.merge(getInversionista(), getInversionista().getIdInversionista()-1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(Integer id) throws Exception {
    //Comprobar si existe inversionista
    for (int i = 0; i < getListAll().getSize(); i++){
        Inversionista invs = getListAll().get(i);
        if (inversionista.getIdInversionista().equals(id)){
            getListAll().delete(i);
            return true;
        }
      }
    throw new Exception("No existe inversionista");
    }

        //ordenamiento por insercion
    public LinkedList order(Integer type_order, String atributo) {
        LinkedList listita = listAll();
        if (!listAll().isEmpty()) {
            Inversionista[] lista = (Inversionista[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Inversionista aux = lista[i]; // valor a ordenar
                int j = i - 1; // índice anterior
                while (j >= 0 && (verify(lista[j], aux, type_order, atributo))) {
                    lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                }
                lista[j + 1] = aux; // inserta el valor en su posición correcta
            }

            listita.toList(lista);
        }
        return listita;
    }

    private Boolean verify(Inversionista a, Inversionista b, Integer type_order, String atributo) {
        if (type_order == 1) {
            if (atributo.equalsIgnoreCase("apellido")) {
                return a.getApellido().compareTo(b.getApellido()) > 0;
            } else if (atributo.equalsIgnoreCase("nombre")) {
                return a.getNombre().compareTo(b.getNombre()) > 0;
            } else if (atributo.equalsIgnoreCase("id")) {
                return a.getIdInversionista() > b.getIdInversionista();
            }
        } else {
            if (atributo.equalsIgnoreCase("apellido")) {
                return a.getApellido().compareTo(b.getApellido()) < 0;
            } else if (atributo.equalsIgnoreCase("nombre")) {
                return a.getNombre().compareTo(b.getNombre()) < 0;
            } else if (atributo.equalsIgnoreCase("id")) {
                return a.getIdInversionista() < b.getIdInversionista();
            }
        }
        return false;
    }

    public LinkedList<Inversionista> buscarPorapellido(String texto) {
        LinkedList<Inversionista> lista = new LinkedList<>();
        LinkedList<Inversionista> listita = listAll();
        if (!listita.isEmpty()) {
            Inversionista[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellido().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public Inversionista buscar_identificacion(String texto) {
        Inversionista inversionista = null;
        LinkedList<Inversionista> listita = listAll();
        if (!listita.isEmpty()) {
            Inversionista[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    inversionista = aux[i];
                    break;
                }
            }
        }
        return inversionista;
    }


}
