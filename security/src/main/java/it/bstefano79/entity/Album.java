package it.bstefano79.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.bstefano79.dto.AlbumDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "albums")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	  
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String name;
	  
	@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "album_types", joinColumns =
			@JoinColumn(name = "album_id", referencedColumnName = "id"), 
	  			inverseJoinColumns =  @JoinColumn(name = "type_id"))
	private List<AlbumType> types;
	
	public Album(){
		
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

	public List<AlbumType> getTypes() {
		return types;
	}

	public void setTypes(List<AlbumType> types) {
		this.types = types;
	}

}
