package it.bstefano79.dto;

import it.bstefano79.entity.FigurineTypes;

public class FigurineTypesDto {
	private String id;
	
	public FigurineTypesDto() {
		super();
	}

	public FigurineTypesDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public FigurineTypesDto(FigurineTypes f) {
		super();
		this.id = f.getId();
		this.name = f.getName();
	}

	private String name;

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
}
