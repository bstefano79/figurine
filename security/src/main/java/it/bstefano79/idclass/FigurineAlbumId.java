package it.bstefano79.idclass;

import java.io.Serializable;
import java.util.Objects;

import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineTypes;

public class FigurineAlbumId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String value;
	
	private Album album;
	
	private FigurineTypes figurineTypes;
	
	public FigurineAlbumId(){
		
	}
	
	public FigurineAlbumId(String value, Album album) {
		super();
		this.value = value;
		this.album = album;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(album, figurineTypes, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FigurineAlbumId other = (FigurineAlbumId) obj;
		return Objects.equals(album, other.album) && Objects.equals(figurineTypes, other.figurineTypes)
				&& Objects.equals(value, other.value);
	}

}
