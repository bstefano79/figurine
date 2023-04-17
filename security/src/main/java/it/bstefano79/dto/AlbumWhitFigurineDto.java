package it.bstefano79.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;

class Figurina{
	private Integer id;
	
	private String value;

	public Figurina(Integer id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}


public class AlbumWhitFigurineDto extends AlbumDto {
	private Map<FigurineTypesDto,List<Figurina>> figurine;
	
	public AlbumWhitFigurineDto(Album album, List<FigurineAlbum> figurine) {
		if(album!=null) {
			this.setName(album.getName());
			this.setId(album.getId());
			this.setTypes(album.getTypes().stream().map(x->x.getName()).toList());
			if(figurine!=null) {
				List<Figurina> lista = figurine.stream().map(x->costructNameFig(x)).toList();
				if(lista!=null && lista.size()>0) {
					this.figurine = new HashMap<FigurineTypesDto, List<Figurina>>();
					for (FigurineAlbum figurina : figurine) {
						FigurineTypesDto key = new FigurineTypesDto(figurina.getFigurineTypes());
						if(!this.figurine.containsKey(key)){
							this.figurine.put(key, new ArrayList<Figurina>());
						}
						this.figurine.get(key).add(costructNameFig(figurina));
					}
				}
			}
		}
	}
	
	private Figurina costructNameFig(FigurineAlbum f) {
		return new Figurina(f.getId(), f.getValue());
	}

	public Map<FigurineTypesDto, List<Figurina>> getFigurine() {
		return figurine;
	}

	public void setFigurine(Map<FigurineTypesDto, List<Figurina>> figurine) {
		this.figurine = figurine;
	}
}
