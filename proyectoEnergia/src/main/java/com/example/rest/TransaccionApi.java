/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rest;

import com.example.controller.dao.services.TransaccionServices;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import javax.ws.rs.*;
/**
 *
 * @author maria-chuico
 */

@Path("/transaccion")
public class TransaccionApi {
        private final TransaccionServices transaccionServices = new TransaccionServices();

    // Endpoint para listar todas las transacciones
        @GET
        @Path("/lista")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAllTransacciones() {
            HashMap<String, Object> map = new HashMap<>();
            try {
                map.put("msg", "Lista de transacciones");
                map.put("data", transaccionServices.listAllTransacciones().toArray());
                return Response.ok(map).build();
            } catch (Exception e) {
                map.put("msg", "Error al obtener la lista de transacciones");
                map.put("error", e.getMessage());
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(map).build();
            }
    }
    
}
