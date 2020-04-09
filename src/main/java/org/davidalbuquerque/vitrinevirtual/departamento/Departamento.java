package org.davidalbuquerque.vitrinevirtual.departamento;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Departamento extends PanacheEntity 
{
	
	public String nome;
	public String descricao;
	
	
}
