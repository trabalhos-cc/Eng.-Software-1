package unioeste.geral.controleestoque.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("rest")
public class UCControleEstoqueWS {
//    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public UCControleEstoqueWS() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of UCControleEstoqueWS
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        // TODO return proper representation object
        return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    }

    /**
     * PUT method for updating or creating an instance of UCControleEstoqueWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}