package org.davidalbuquerque.vitrinevirtual.produto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.davidalbuquerque.vitrinevirtual.departamento.Departamento;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Produto extends PanacheEntity
{
	
	public String titulo;
	
	public String detalhe;
	
	@Column(scale = 2)
	public BigDecimal preco;
	
	public String foto1;
	
	@ManyToOne
	public Departamento departamento;
}
