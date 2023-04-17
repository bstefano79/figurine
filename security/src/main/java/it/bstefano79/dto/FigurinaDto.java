package it.bstefano79.dto;

import java.io.Serializable;


public class FigurinaDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String value;
	
	private Integer idAlbum;
	
	private FigurineTypesDto figurineTypes = new FigurineTypesDto("F","Figurine");
	
	public FigurinaDto(){
		
	}
	

	public FigurinaDto(Integer id, String value, Integer idAlbum, FigurineTypesDto figurineTypes) {
		super();
		this.id = id;
		this.value = value;
		this.idAlbum = idAlbum;
		this.figurineTypes = figurineTypes;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public Integer getIdAlbum() {
		return idAlbum;
	}


	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}


	public FigurineTypesDto getFigurineTypes() {
		return figurineTypes;
	}


	public void setFigurineTypes(FigurineTypesDto figurineTypes) {
		this.figurineTypes = figurineTypes;
	}
}
