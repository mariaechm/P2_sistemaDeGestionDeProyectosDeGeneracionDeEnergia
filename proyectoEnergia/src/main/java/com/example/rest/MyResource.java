package com.example.rest;

import java.util.HashMap;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.controller.dao.InversionistaDao;
import com.example.controller.dao.services.InversionistaServices;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Inversionista;

import org.apache.commons.math3.stat.descriptive.summary.Product;


import com.example.controller.dao.ProyectoDao;
import com.example.controller.dao.services.ProyectoServices;
import com.example.models.Proyecto;
import com.example.models.enumerator.TipoProyecto;

import com.example.controller.dao.TransaccionDao;
import com.example.controller.dao.services.TransaccionServices;
import com.example.models.Transaccion;

import com.example.rest.InversionistaApi;
import com.example.rest.ProyectoApi;
import com.example.rest.TransaccionApi;



@Path("/myresource")
public class MyResource {

    private static final Logger logger = Logger.getLogger(MyResource.class.getName());

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {        
        HashMap mapa = new HashMap<>();        
        InversionistaServices pd = new InversionistaServices();
        String aux = "";
        try {            
            aux = "La lista esta vacia "+pd.listAll().isEmpty();
            LinkedList<Double> listaA = new LinkedList<>();
            for(int i = 0; i < 15; i++) {
                double roundedNumber = Math.round((Math.random()*100) * 100.0) / 100.0;
                listaA.add(roundedNumber);
            }
            System.out.println(listaA.toString());
            listaA.order(LinkedList.ASC);
            System.out.println(listaA.toString());
            //obejtos
            System.out.println(pd.listAll().toString());
            System.out.println(pd.order_object(LinkedList.ASC, "apellidos"));

        } catch (Exception e) {
            System.out.println("Error "+e);
            // TODO: handle exception
        }
        mapa.put("msg", "OK");        
        mapa.put("data", "test "+aux);
        return Response.ok(mapa).build();
    }
}
