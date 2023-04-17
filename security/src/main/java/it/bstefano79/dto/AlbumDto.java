package it.bstefano79.dto;

import java.util.List;

import it.bstefano79.entity.Album;

public class AlbumDto {
	private Integer id;
	
	private String name;
	
	private List<String> types;
	
	public AlbumDto() {
		
	}
	
	public AlbumDto(Album album) {
		if(album!=null) {
			this.name=album.getName();
			this.id=album.getId();
			this.types=album.getTypes().stream().map(x->x.getName()).toList();
		}
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
}
