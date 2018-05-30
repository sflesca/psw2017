package org.ProvaWebDB.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Categoria")
@XmlRootElement
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	public Categoria() {
	}

	@Id
	private long id;
	private String nome;
	@OneToMany(mappedBy = "categoria")
	private Collection<Prodotto> prodotto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String param) {
		this.nome = param;
	}

	public Collection<Prodotto> getProdotto() {
		return prodotto;
	}

	public void setProdotto(Collection<Prodotto> param) {
		this.prodotto = param;
	}

}