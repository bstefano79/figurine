package it.bstefano79.dto;

import java.util.Objects;

import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;
import it.bstefano79.entity.FigurineTypes;

public class FigurineTypesDto {
	private String id;
	
	private String name;
	
	public FigurineTypesDto() {
		super();
	}

	public FigurineTypesDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static FigurineTypesDto fromFigurineTypes(FigurineTypes ft) {
		if(ft==null) return null;
		FigurineTypesDto ftDto = new FigurineTypesDto();
		
		ftDto.setId(ft.getId());
		ftDto.setName(ft.getName());
		
		return ftDto;
	
	}
	
	public static FigurineTypes toFigurineTypes(FigurineTypesDto ftDto) {
		if(ftDto==null) return null;
		FigurineTypes ft = new FigurineTypes();
        ft.setId(ftDto.getId());
        ft.setName(ftDto.getName());
        return ft;
    }


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FigurineTypesDto other = (FigurineTypesDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name;
	}
}
