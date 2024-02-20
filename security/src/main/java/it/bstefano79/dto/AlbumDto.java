package it.bstefano79.dto;

import java.util.List;

import it.bstefano79.entity.Album;

public class AlbumDto {
	private Integer id;
	
	private String name;
	
	private List<AlbumTypeDto> types;
	
	public AlbumDto() {
		
	}
	
	public static AlbumDto fromAlbum(Album album) {
		if(album!=null) {
			AlbumDto a = new AlbumDto();
	
			a.name=album.getName();
			a.id=album.getId();
			a.types = album.getTypes().stream().map(x -> AlbumTypeDto.fromAlbumType(x)).toList();
			return a;
		}
		return null;
	}
	
	public static Album toAlbum(AlbumDto a) {
		Album album = new Album();
        album.setId(a.getId());
        album.setName(a.getName());
        album.setTypes(a.getTypes().stream().map(x -> AlbumTypeDto.toAlbumType(x)).toList());
        return album;
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

	public List<AlbumTypeDto> getTypes() {
		return types;
	}

	public void setTypes(List<AlbumTypeDto> types) {
		this.types = types;
	}
}
