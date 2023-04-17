package it.bstefano79.dto;

import java.util.List;


import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;

public class AlbumDto {
	private Integer id;
	
	private String name;
	
	private List<String> types;
	
	private List<FigurinaDto> figurine;
	
	public AlbumDto() {
		
	}

	public AlbumDto(Album album, List<FigurineAlbum> figurine) {
		if(album!=null) {
			this.name=album.getName();
			this.id=album.getId();
			this.types=album.getTypes().stream().map(x->x.getName().name()).toList();
			if(figurine!=null) {
				this.figurine=figurine.stream().map(x->costructNameFig(x)).toList();
			}
		}
	}
	
	private FigurinaDto costructNameFig(FigurineAlbum f) {
		return new FigurinaDto(f.getId(), f.getValue(), null, new FigurineTypesDto(f.getFigurineTypes()));
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<FigurinaDto> getFigurine() {
		return figurine;
	}

	public void setFigurine(List<FigurinaDto> figurine) {
		this.figurine = figurine;
	}
}
