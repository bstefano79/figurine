package it.bstefano79.dto;

import java.io.Serializable;

import it.bstefano79.entity.FigurineAlbum;


public class FigurineAlbumDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String value;
	
	private Integer idAlbum;
	
	private FigurineTypesDto figurineTypes; //new FigurineTypesDto("F","Figurine");
	
	public FigurineAlbumDto(){
		
	}

	public FigurineAlbumDto(Integer id, String value, Integer idAlbum, FigurineTypesDto figurineTypes) {
		super();
		this.id = id;
		this.value = value;
		this.idAlbum = idAlbum;
		this.figurineTypes = figurineTypes;
	}
	
	public static FigurineAlbumDto fromFigurineAlbum(FigurineAlbum fa, boolean includeAlbum, boolean includeFigurineTypes) {
		if(fa==null || fa.getAlbum()==null) return null;
		FigurineAlbumDto faDto = new FigurineAlbumDto();
		
		faDto.setId(fa.getId());
		faDto.setValue(fa.getValue());
		if(includeAlbum) {
			faDto.setIdAlbum(fa.getAlbum().getId());
		}
		if (includeFigurineTypes) {
			faDto.setFigurineTypes(FigurineTypesDto.fromFigurineTypes(fa.getFigurineTypes()));
		}
		return faDto;
	}

	
	public static FigurineAlbumDto fromFigurineAlbum(FigurineAlbum fa) {
		return fromFigurineAlbum(fa, false, false);
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
