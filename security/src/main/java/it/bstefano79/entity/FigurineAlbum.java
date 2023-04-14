package it.bstefano79.entity;

import it.bstefano79.idclass.FigurineAlbumId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "figurine_album")
@IdClass(FigurineAlbumId.class)
public class FigurineAlbum {
	
	@Id
	@Column(length = 5)
	private String value;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_album")
	private Album album;
	
	@Id
	@ManyToOne
	@JoinColumn(name="figurine_types")
	private FigurineTypes figurineTypes = new FigurineTypes("F","Figurine");

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

	
}
