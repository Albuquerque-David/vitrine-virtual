package org.davidalbuquerque.vitrinevirtual.produto;

import java.net.URI;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/produtos")
@Transactional
public class ProdutoEndpoint 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaProdutos()
	{
		
		return Response.ok(Produto.listAll())
				.build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") Long id)
	{
		return Response.ok(Produto.findById(id))
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Produto produto)
	{
		produto.id = null;
		produto.persist();
		
		return Response.created(URI.create(String.format("/produtos/%d",produto.id)))
				.build();
	}
}
