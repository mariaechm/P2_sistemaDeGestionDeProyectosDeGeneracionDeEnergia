/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rest;

import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controller.tda.list.LinkedList;
import com.example.models.Inversionista;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import com.example.controller.dao.services.InversionistaServices;
/**
 *
 * @author maria-chuico
 */

@Path("/inversionista")
public class InversionistaApi {

    @Path("/listas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRelacion() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        InversionistaServices is = new InversionistaServices();
        
        // Obtiene todos los inversionistas
        LinkedList<Inversionista> lista = is.listAll();

        if (lista.isEmpty()) {
            map.put("msg", "No hay inversionistas registrados");
            map.put("data", new Object[]{});
        } else {
            map.put("msg", "Lista de inversionistas registrados");
            map.put("data", lista.toArray());
        }
        
        return Response.ok(map).build();
    }

    @Path("/asociar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, String> map) throws Exception {
        HashMap<String, String> res = new HashMap<>();
        try {
            InversionistaServices is = new InversionistaServices();
            Inversionista inversionista = is.getInversionista();
            inversionista.setNombre(map.get("nombre"));
            inversionista.setApellido(map.get("apellido"));
            inversionista.setNacionalidad(map.get("dni"));
            inversionista.setIdentificacion(map.get("identificacion"));
            is.setInversionista(inversionista); // Guarda el objeto Inversionista en el servicio
            is.save(); // Llama al método save del servicio
            res.put("msg", "Inversionista asociado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            res.put("msg", "ERROR");
            res.put("data", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}
