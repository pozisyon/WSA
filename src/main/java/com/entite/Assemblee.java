/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entite;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

/**
 *
 * @author trompe
 */
@Path("assemblee")
public class Assemblee {
    private ArrayList<Personne> personnes;
    public Assemblee(){
        personnes = new ArrayList<>();
        personnes.add(new Personne("Theodore","Wideline"));
        personnes.add(new Personne("Baptiste","Nephthalie"));
        personnes.add(new Personne("Joseph","Collegue"));
        personnes.add(new Personne("Jean","Abdias"));
            
    }
    
    public ArrayList<Personne> getListePersonne(){
        return personnes;
    }
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/premier")
    public Personne getPremierePersonneDelaListe(){
        return personnes.get(0);
    }
    
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/{index}")
    public Personne getUnePersonne(@PathParam("index") String index){
        return personnes.get(Integer.parseInt(index));
    }
    
   @PUT
   @Path("/ajout")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_PLAIN)
    public boolean ajouterPersonne(String per){
        Personne personne = new Gson().fromJson(per, Personne.class);
       System.out.println("personne ajoutee: "+personne.getNom());
       getListePersonne().add(personne);  
        return true;
    }
    
     @GET
    public Response ping(){
        return Response
                .ok(getListePersonne())
                .build();
    }
    
}
