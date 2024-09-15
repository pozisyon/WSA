package com.mycompany.wsa.resources;

import com.entite.Personne;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok(new Personne("Trompe","Louis Jean Marie"))
                .build();
    }
}
