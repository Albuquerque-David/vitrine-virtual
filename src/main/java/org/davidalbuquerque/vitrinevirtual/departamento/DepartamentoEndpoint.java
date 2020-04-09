package org.davidalbuquerque.vitrinevirtual.departamento;

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


@Path("/departamentos")
@Transactional
public class DepartamentoEndpoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos()
	{
		return Response.ok(Departamento.listAll()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") Long id)
	{
		return Response.ok(Departamento.findById(id))
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Departamento departamento) 
	{
		departamento.id = null;
		departamento.persist();
		
		return Response.created(URI.create(String.format("/departamentos/%d",departamento.id)))
				.build();
	}
}
