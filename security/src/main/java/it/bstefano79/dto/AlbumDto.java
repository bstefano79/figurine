package it.bstefano79.dto;

import java.util.List;

import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;

public class AlbumDto {
	private Integer id;
	
	private String name;
	
	private List<String> types;
	
	private List<String> figurine;
	
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
	
	private String costructNameFig(FigurineAlbum f) {
		String res=!("F".equals(f.getFigurineTypes().getId()))?
				f.getFigurineTypes().getId():"";
		return res+f.getValue();
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

	public List<String> getFigurine() {
		return figurine;
	}

	public void setFigurine(List<String> figurine) {
		this.figurine = figurine;
	}
}
