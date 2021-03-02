package nl.han.dea.services;

import nl.han.dea.services.dto.ItemDTO;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/items")
@Singleton
public class ItemsResource {
    private ItemService itemService;

    public ItemsResource() {
        this.itemService = new ItemService();
    }
//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getItems() {
//        return "bread, butter";
//    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getItemsJSON() {
//        return "[\"bread\", \"butter\"]";
//    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ItemDTO> getItemsJSON() {
//        return itemService.getAll();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsJSON() {
        return Response.ok().entity(itemService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("id") int id) {
        return Response.ok().entity(itemService.getItem(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("id") int id) {
        itemService.deleteItem(id);
        System.out.println(itemService);
        return Response.ok().build();
    }

}
