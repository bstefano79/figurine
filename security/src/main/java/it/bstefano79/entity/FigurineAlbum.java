package it.bstefano79.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "figurine_album")
public class FigurineAlbum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 5)
	private String value;
	
	@ManyToOne
	@JoinColumn(name="id_album")
	private Album album;
	
	@ManyToOne
	@JoinColumn(name="figurine_types")
	private FigurineTypes figurineTypes;// = new FigurineTypes("F","Figurine");

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public FigurineTypes getFigurineTypes() {
		return figurineTypes;
	}

	public void setFigurineTypes(FigurineTypes figurineTypes) {
		this.figurineTypes = figurineTypes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
