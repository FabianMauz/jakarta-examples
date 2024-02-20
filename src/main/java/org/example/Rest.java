package org.example;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;

@Path("/rest")
@Stateless
public class Rest {
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello World from a REST endpoint";
    }

}
