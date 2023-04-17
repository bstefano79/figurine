package it.bstefano79.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "figurine_types")
public class FigurineTypes {
	@Id
	@Column(length = 3)
	private String id;
	
	@Column(length = 30)
	private String name;
	
	@Column
	@NotNull
	private boolean type_default = false;
	
	public FigurineTypes(){
		
	}
	
	public FigurineTypes(String id, String name){
		this.id=id;
		this.name=name;
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

	public boolean isType_default() {
		return type_default;
	}

	public void setType_default(boolean type_default) {
		this.type_default = type_default;
	}
}
