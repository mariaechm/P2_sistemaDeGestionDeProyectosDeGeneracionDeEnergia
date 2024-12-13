/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rest;

import java.util.Collections;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controller.dao.services.ProyectoServices;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Proyecto;
import com.example.models.enumerator.TipoProyecto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author maria-chuico
 */

 @Path("/proyecto")
 public class ProyectoApi {
 
     @Path("/list")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getRelacion() throws Exception {
         HashMap<String, Object> map = new HashMap<>();
         ProyectoServices is = new ProyectoServices();
         
         // Obtiene todos los Proyectos
         LinkedList <Proyecto> lista = is.listAll();
 
         if (lista.isEmpty()) {
             map.put("msg", "No hay Proyectos registrados");
             map.put("data", new Object[]{});
         } else {
             map.put("msg", "Lista de Proyectos registrados");
             map.put("data", lista.toArray());
         }
         ObjectMapper om = new ObjectMapper();
         return Response.ok(om.writeValueAsString(map)).build();
     }
 
     @Path("/save")
     @POST
     @Produces(MediaType.APPLICATION_JSON)
     public Response save(HashMap<String, String> map) throws Exception {
         HashMap<String, String> res = new HashMap<>();
         try {
             ProyectoServices is = new ProyectoServices();
             Proyecto proyecto = is.getProyecto();
             //proyecto.setId(Integer.parseInt(map.get("id").toString()));
             proyecto.setNombre(map.get("nombre"));
             proyecto.setFechaInicio(map.get("fechaInicio"));
             proyecto.setFechaFin(map.get("fechaFin"));
             proyecto.setMontoInversion(Float. parseFloat(map.get("montoInversion").toString()));
             proyecto.setTiempoDeVida(Integer.parseInt (map.get("tiempoDeVida").toString()));
             proyecto.setTipo(TipoProyecto.valueOf(map.get("tipoProyecto").toString()));
             
            
             is.setProyecto(proyecto); // Guarda el objeto Proyecto en el servicio
             is.save(); // Llama al método save del servicio
             res.put("msg", "Proyecto guardado");

            ObjectMapper om = new ObjectMapper();
            return Response.ok(om.writeValueAsString(res)).build();

         } catch (Exception e) {
             System.out.println("Error: " + e.toString());
             res.put("msg", "ERROR");
             res.put("data", e.getMessage());
             return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
         }
     }
 
     @Path("/delete/{id}")
     @DELETE
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Response delete(@PathParam("id") Integer id) { // Extraer el id de la URL {id}
         HashMap res = new HashMap<>();
 
         ProyectoServices ps = new ProyectoServices();
       
         try {
             ps.delete(id);
             res.put("msg", "OK");
             res.put("status", "Proyecto Eliminado");
             
             ObjectMapper om = new ObjectMapper();
             return Response.ok(om.writeValueAsString(res)).build();
 
         } catch (Exception e) {
             System.out.println("Error" + e.toString());
             res.put("msg", "Error");
             res.put("data", e.toString());
             return Response.status(Status.BAD_REQUEST).entity(res).build();
 
         }
 
     }
 
     @Path("/update")
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Response update(HashMap map) {
         HashMap res = new HashMap<>();
 
         System.out.println("ASAS");
         ProyectoServices ps = new ProyectoServices();
        
       
         try {
             ps.getProyecto().setId(Integer.parseInt(map.get("id").toString()));
             ps.getProyecto().setNombre(map.get("nombre").toString());
             ps.getProyecto().setFechaInicio(map.get("fechaInicio").toString());
             ps.getProyecto().setFechaFin(map.get("fechaFin").toString());
             ps.getProyecto().setMontoInversion(Float. parseFloat(map.get("montoInversion").toString()));
             ps.getProyecto().setTiempoDeVida(Integer.parseInt (map.get("tiempoDeVida").toString()));
             ps.getProyecto().setTipo(TipoProyecto.valueOf(map.get("tipoProyecto").toString()));
 
             ps.update();
             res.put("msg", "OK");
             res.put("data", "Proyecto Registarado");
             
            ObjectMapper om = new ObjectMapper();
            return Response.ok(om.writeValueAsString(res)).build();
 
         } catch (Exception e) {
             System.out.println("Error" + e.toString());
             res.put("msg", "Error");
             res.put("data", e.toString());
             return Response.status(Status.BAD_REQUEST).entity(res).build();
 
         }
     }
 
     @Path("/get/{id}")
     @GET
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Response get(@PathParam("id") Integer id) {
         HashMap res = new HashMap<>();
 
         
         ProyectoServices ps = new ProyectoServices();
       
         try {         
             res.put("msg", "OK");
             res.put("data", ps.get(id));
             ObjectMapper om = new ObjectMapper();
             return Response.ok(om.writeValueAsString(res)).build();
 
         } catch (Exception e) {
             System.out.println("Error" + e.toString());
             res.put("msg", "Error");
             res.put("data", e.toString());
             return Response.status(Status.BAD_REQUEST).entity(res).build();
 
         }
     }
 
     @Path("/sort/{attribute}/{orden}/{method}")
     @GET
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Response get(@PathParam("attribute") String attribute,
                         @PathParam("orden") Integer orden, 
                         @PathParam("method") Integer method){
                         HashMap res = new HashMap<>();
         ProyectoServices ps = new ProyectoServices();
       
         try {         
             res.put("msg", "OK");
             res.put("data", ps.order(orden,attribute,method).toArray());

             ObjectMapper om = new ObjectMapper();
             return Response.ok(om.writeValueAsString(res)).build();
 
         } catch (Exception e) {
             System.out.println("Error" + e.toString());
             res.put("msg", "Error");
             res.put("data", e.toString());
             return Response.status(Status.BAD_REQUEST).entity(res).build();
 
         }
     }
 
     @Path("/search/{attribute}/{buscar}")
     @GET
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Response get(@PathParam("attribute") String attribute,
                         @PathParam("buscar") String valor){
                         HashMap res = new HashMap<>();
         ProyectoServices ps = new ProyectoServices();
       
         try {         
             res.put("msg", "OK");
             res.put("data", ps.buscar(attribute, valor));

             ObjectMapper om = new ObjectMapper();
             return Response.ok(om.writeValueAsString(res)).build();
 
         } catch (Exception e) {
             System.out.println("Error" + e.toString());
             res.put("msg", "Error");
             res.put("data", e.toString());
             return Response.status(Status.BAD_REQUEST).entity(res).build();
 
         }
     }
     
 }