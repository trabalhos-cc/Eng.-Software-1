package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("restws")
public class MyFirstWebService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public MyFirstWebService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of MyFirstWebService
     * @return an instance of String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        // TODO return proper representation object
        return "Hello World";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("sayOla/{nome}")
    public String sayOla(@PathParam(value="nome") String nome) {
        return "Ola "+nome;
    }

//    /**
//     * PUT method for updating or creating an instance of MyFirstWebService
//     * @param content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//    @PUT
//    @Consumes("application/xml")
//    public void putXml(String content) {
//    }

}