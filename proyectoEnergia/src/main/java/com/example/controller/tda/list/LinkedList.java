/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.tda.list;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.controller.exception.ListEmptyException;

/**
 *
 * @author maria-chuico
 */

 public class LinkedList<E>{
    private Node <E> header;
    private Node <E> last;
    private Integer size;
    public static Integer ASC =1;
    public static Integer DESC = 0;

    // Clase para lista enlazada

    public LinkedList(){
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    public Boolean isEmpty (){
        return this.header == null || this.size == 0;
    }

    private void addHeader (E dato){
        Node <E> help;
        if (isEmpty()){
            help = new Node <> (dato);
            header = help;
            this.last = help;
        }else{
            Node <E> healpHeader = this.header;
            help = new Node <> (dato, healpHeader);
            this.header = help;
        }
        this.size++;
    }

    private void addLast(E info) {
        Node<E> help;
        if (isEmpty()) {
            addHeader(info);
        } else {
            help = new Node<>(info, null);
            last.setNext(help);
            last = help;
            this.size++;
        }
    }

    public void add (E info){
        addLast(info);
    }

    //GET
    private Node<E> getNode(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, List empty");
        } else if (index.intValue() < 0 || index.intValue() >= this.size) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == 0) {
            return header;
        } else if (index.intValue() == (this.size - 1)) {
            return last;
        } else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    private E getFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, Lista vacia");
        }
        return header.getInfo();
    }

    private E getLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, Lista vacia");
        }
        return last.getInfo();
    }

    public E get(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, List empty");
        } else if (index.intValue() < 0 || index.intValue() >= this.size.intValue()) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == 0) {
            return header.getInfo();
        } else if (index.intValue() == (this.size - 1)) {
            return last.getInfo();
        } else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()) {
                cont++;
                search = search.getNext();
            }
            return search.getInfo();
        }

    }

    /********* END GET */
    /*** ADD BY POSITION */
    public void add(E info, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty() || index.intValue() == 0) {
            addHeader(info);
        } else if (index.intValue() == this.size.intValue()) {
            addLast(info);
        } else {

            Node<E> search_preview = getNode(index - 1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info, search);
            search_preview.setNext(help);
            this.size++;
        }
    }

    /*** END BY POSITION */
    public void reset() {
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List Data \n");
        try {

            Node<E> help = header;
            while (help != null) {
                sb.append(help.getInfo()).append(" -> ");
                help = help.getNext();
            }
        } catch (Exception e) {
            sb.append(e.getMessage());
        }

        return sb.toString();
    }

    public Integer getSize() {
        return this.size;
    }

    public E[] toArray() {
        E[] matrix = null;
        if (!isEmpty()) {
            Class clazz = header.getInfo().getClass();
            matrix = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            Node<E> aux = header;
            for (int i = 0; i < this.size; i++) {
                matrix[i] = aux.getInfo();
                aux = aux.getNext();
            }
        }
        return matrix;
    }

    public LinkedList<E> toList(E[] matrix) {
        reset();
        for (int i = 0; i < matrix.length; i++) {
            this.add(matrix[i]);
        }
        return this;
    }

    public void update(E data, Integer post) throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, la lista esta vacia");
        } else if (post < 0 || post >= size) {
            throw new IndexOutOfBoundsException("Error, esta fuera de los limites de la lista");
        } else if (post == 0) {
            header.setInfo(data);
        } else if (post == (size - 1)) {
            last.setInfo(data);
        } else {
            // 2 5 6 9 --> 2
            Node<E> search = header;
            Integer cont = 0;
            while (cont < post) {
                cont++;
                search = search.getNext();
            }
            search.setInfo(data);
        }
    }

    public E deleteFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Lista vacia");
        } else {
            E element = header.getInfo();
            Node<E> aux = header.getNext();
            header = aux;
            if (size.intValue() == 1) {
                last = null;
            }
            size--;
            return element;
        }
    }

    public E deleteLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Lista vacia");
        } else {
            E element = last.getInfo();
            Node<E> aux = getNode(size - 2);
            if (aux == null) {
                last = null;
                if (size == 2) {
                    last = header;
                } else {
                    header = null;
                }
            } else {
                last = null;
                last = aux;
                last.setNext(null);
            }
            size--;
            return element;
        }
    }

    public E delete(Integer post) throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, la lista esta vacia");
        } else if (post < 0 || post >= size) {
            throw new IndexOutOfBoundsException("Error, esta fuera de los limites de la lista");
        } else if (post == 0) {
            return deleteFirst();
        } else if (post == (size - 1)) {
            return deleteLast();
        } else {
            Node<E> preview = getNode(post - 1);
            Node<E> actually = getNode(post);
            E element = preview.getInfo();
            Node<E> next = actually.getNext();
            actually = null;
            preview.setNext(next);
            size--;
            return element;
        }
    }

    //ordenar

    public LinkedList<E> order(Integer type) throws Exception {
        if (!isEmpty()) {
            E data = this.header.getInfo();
            if (data instanceof Number || data instanceof String) {
                E[] lista = this.toArray();
                reset();
                for (int i = 1; i < lista.length; i++) {
                    E aux = lista[i]; // valor a ordenar
                    int j = i - 1; // índice anterior
                    while (j >= 0 && compare(lista[j], aux, type)) {
                        lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                    }
                    lista[j + 1] = aux; // inserta el valor en su posición correcta
                }
                this.toList(lista);
            }
        }
        return this;
    }

    public LinkedList<E> order(String attribute, Integer type) throws Exception {
        if (!isEmpty()) {
            E data = this.header.getInfo();
            if (data instanceof Object) {
                E[] lista = this.toArray();
                reset();
                for (int i = 1; i < lista.length; i++) {
                    E aux = lista[i]; // valor a ordenar
                    int j = i - 1; // índice anterior
                    while (j >= 0 && atrribute_compare(attribute, lista[j], aux, type)) {
                        lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                    }
                    lista[j + 1] = aux; // inserta el valor en su posición correcta
                }
                this.toList(lista);
            }
        }
        return this;
    }

    private Boolean compare(Object a, Object b, Integer type) {
        switch (type) {
            case 0:
                if (a instanceof Number) {
                    Number a1 = (Number) a;
                    Number b1 = (Number) b;
                    return a1.doubleValue() > b1.doubleValue();
                } else {
                    // "casa" > "pedro"
                    return (a.toString()).compareTo(b.toString()) > 0;
                }
                // break;

            default:
                // mayor a menor
                if (a instanceof Number) {
                    Number a1 = (Number) a;
                    Number b1 = (Number) b;
                    return a1.doubleValue() < b1.doubleValue();
                } else {
                    // "casa" > "pedro"
                    return (a.toString()).compareTo(b.toString()) < 0;
                }
                // break;
        }

    }

    // compare class
    private Boolean atrribute_compare(String attribute, E a, E b, Integer type) throws Exception {
        return compare(exist_attribute(a, attribute), exist_attribute(b, attribute), type);
    }

    private Object exist_attribute(E a, String attribute) throws Exception {
        Method method = null;
        attribute = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
        attribute = "get" + attribute;
        for (Method aux : a.getClass().getMethods()) {           
            if (aux.getName().contains(attribute)) {
                method = aux;
                break;
            }
        }
        if (method == null) {
            for (Method aux : a.getClass().getSuperclass().getMethods()) {              
                if (aux.getName().contains(attribute)) {
                    method = aux;
                    break;
                }
            }
        }
        if (method != null) {            
            return method.invoke(a);
        }
        
        return null;
    }

    //metodo de ordenacion mergeSort
    public LinkedList<E> mergeSort() throws Exception {
        if (isEmpty() || this.size <= 1) {
            return this;
        }
    
        // Dividir la lista en dos mitades
        LinkedList<E> left = new LinkedList<>();
        LinkedList<E> right = new LinkedList<>();
        int mid = this.size / 2;
        for (int i = 0; i < mid; i++) {
            left.add(get(i));
        }for (int i = mid; i < this.size; i++) {
            right.add(get(i));
        }
    
        // Ordenar las mitades de forma recursiva
        left.mergeSort();
        right.mergeSort();
    
        // Mezclar las mitades ordenadas
        merge(left, right);
        return this;
    }
    
   private void merge(LinkedList<E> left, LinkedList<E> right) throws Exception {
    int i = 0, j = 0, k = 0;

    // Asegurarse de que ambos índices no se excedan de los límites de sus listas
    while (i < left.getSize() && j < right.getSize()) {
        // Comparamos los elementos en las listas usando compareTo
        if (((Comparable<E>) left.get(i)).compareTo(right.get(j)) <= 0) {
            // Primero obtenemos el valor de la lista izquierda, luego incrementamos 'i' y 'k'
            add(k, left.get(i));  
            i++;
            k++;
        } else {
            // Primero obtenemos el valor de la lista derecha, luego incrementamos 'j' y 'k'
            add(k, right.get(j));  
            j++;
            k++;
        }
    }

    // Si quedan elementos en la lista izquierda, los añadimos
    while (i < left.getSize()) {
        add(k, left.get(i));
        i++;
        k++;
    }

    // Si quedan elementos en la lista derecha, los añadimos
    while (j < right.getSize()) {
        add(k, right.get(j));
        j++;
        k++;
    }
}


    //metodo de ordenacion quickSort
    public LinkedList<E> shellSort() throws Exception {
        if (isEmpty() || this.size <= 1) {
            return this;
        }
    
        int n = this.size; // tamaño de la lista
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                E temp = get(i);
                int j;
                for (j = i; j >= intervalo && ((Comparable<E>) get(j - intervalo)).compareTo(temp) > 0; j -= intervalo) {
                    set(j, get(j - intervalo));
                }
                set(j, temp);
            }
        }
        return this;
    }
    
    // metodo de busqueda binaria
    public E busquedaBinary(E target) throws ListEmptyException, IndexOutOfBoundsException {
        return busquedaBinaryRecursive(target, 0, this.size - 1);
    }
    
    private E busquedaBinaryRecursive(E target, int left, int right) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error la lista esta vacia");
        }
    
        if (right >= left) {
            int mid = left + (right - left) / 2;
            E midValue = get(mid);
    
            if (((Comparable<E>) midValue).compareTo(target) == 0) {
                return midValue;
            }
    
            if (((Comparable<E>) midValue).compareTo(target) > 0) {
                return busquedaBinaryRecursive(target, left, mid - 1);
            } else {
                return busquedaBinaryRecursive(target, mid + 1, right);
            }
        }
    
        throw new IndexOutOfBoundsException("Error elemento no encontrado");
    }

    private void add(int k, E get) {
        if (k < 0 || k > size) {
        throw new IndexOutOfBoundsException("Índice fuera de los límites");
    }
  }

    private void set(int j, E get) {
        if (j < 0 || j > size) {
        throw new IndexOutOfBoundsException("Índice fuera de los límites");
    }
  }
 
}

