package org.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Articolo")
@XmlRootElement
public class Articolo implements Serializable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articolo other = (Articolo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;

	public Articolo() {
	}

	@Id
	private long id;
	private String titolo;
	private String testo;
	private int numApprezzamenti;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String param) {
		this.titolo = param;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String param) {
		this.testo = param;
	}

	public int getNumApprezzamenti() {
		return numApprezzamenti;
	}

	public void setNumApprezzamenti(int param) {
		this.numApprezzamenti = param;
	}

}