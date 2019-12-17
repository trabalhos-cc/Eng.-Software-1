package rest;

import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("CepRest")
public class CEPRestWS {

	@Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public CEPRestWS() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON )
    @Path("getCep/{CEP}")
    public CEP getCep (@PathParam("CEP") String CEP) {
    	CEP toReturn = new CEP();
        toReturn.setCep(CEP);
        toReturn.setBairro("Bairro "+new Random().nextInt());
        toReturn.setNumero(new Random().nextInt());
        toReturn.setRua("Rua que sempre "+new Random().nextInt());
        toReturn.setUf("PR");
        return toReturn;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("setCep")
    public void setCep(CEP cep) {
    	System.out.println("Objeto CEP recebido! - " + cep);
    	System.out.println("CEP: "+cep.getCep());
    	System.out.println("Rua: "+cep.getRua());
    	System.out.println("Bairro: "+cep.getBairro());
    	System.out.println("Numero: "+cep.getNumero());
    	System.out.println("Uf: "+cep.getUf());
    }
}
