package it.bstefano79.dto;

import it.bstefano79.entity.AlbumType;

public class AlbumTypeDto {
	private Integer id;
	
	private String name;
	
	private boolean type_default;
	
	public AlbumTypeDto() {
		
	}
	
	public AlbumTypeDto(Integer id, String name, boolean type_default) {
		super();
		this.id = id;
		this.name = name;
		this.type_default = type_default;
	}
	
	public static AlbumTypeDto fromAlbumType(AlbumType at) {
		AlbumTypeDto albumTypeDto = new AlbumTypeDto();
        if(at==null) return null;
        albumTypeDto.id=at.getId();
        albumTypeDto.name=at.getName();
        albumTypeDto.type_default=at.isType_default();
        return albumTypeDto;
    }

    public static AlbumType toAlbumType(AlbumTypeDto at) {
    	AlbumType albumType = new AlbumType();
    	if(at==null) return null;
    	albumType.setId(at.getId());
    	albumType.setName(at.getName());
    	albumType.setType_default(at.isType_default());
        return albumType;
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

	public boolean isType_default() {
		return type_default;
	}

	public void setType_default(boolean type_default) {
		this.type_default = type_default;
	}
}
