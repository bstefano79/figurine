package it.bstefano79.entity;

import java.util.HashSet;
import java.util.Set;

import it.bstefano79.models.EAlbumType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	  
	  @Enumerated(EnumType.STRING)
	  @Column(length = 20)
	  private EAlbumType type;
	  
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "album_types", joinColumns =
			  @JoinColumn(name = "album_id", referencedColumnName = "id"), 
	  			inverseJoinColumns =  @JoinColumn(name = "type_id"))
	  private Set<AlbumType> types = new HashSet<>();

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

	public EAlbumType getType() {
		return type;
	}

	public void setType(EAlbumType type) {
		this.type = type;
	}

}
