package nl.han.dea.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items")
public class ItemsResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getItems() {
        return "bread, butter";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonItems() {
        return "[\"bread\", \"butter\"]";
    }
}
