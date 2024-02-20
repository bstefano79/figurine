package it.bstefano79.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;



public class AlbumWhitFigurineDto extends AlbumDto {
	private Map<FigurineTypesDto,List<FigurineAlbumDto>> figurine;
	
	public AlbumWhitFigurineDto(Album album, List<FigurineAlbum> figurine) {
		if(album!=null) {
			this.setName(album.getName());
			this.setId(album.getId());
			this.setTypes(album.getTypes().stream().map(x->AlbumTypeDto.fromAlbumType(x)).toList());
			if(figurine!=null) {
				List<FigurineAlbumDto> lista = figurine.stream().map(x->FigurineAlbumDto.fromFigurineAlbum(x)).toList();
				if(lista!=null && lista.size()>0) {
					this.figurine = new HashMap<FigurineTypesDto, List<FigurineAlbumDto>>();
					figurine.stream().forEach(x -> {
						if(!this.figurine.containsKey(FigurineTypesDto.fromFigurineTypes(x.getFigurineTypes()))) {
							this.figurine.put(FigurineTypesDto.fromFigurineTypes(x.getFigurineTypes()), new ArrayList<FigurineAlbumDto>());
						}
						this.figurine.get(FigurineTypesDto.fromFigurineTypes(x.getFigurineTypes())).add(FigurineAlbumDto.fromFigurineAlbum(x));
					});
				}
			}
		}
	}

	public Map<FigurineTypesDto, List<FigurineAlbumDto>> getFigurine() {
		return figurine;
	}

	public void setFigurine(Map<FigurineTypesDto, List<FigurineAlbumDto>> figurine) {
		this.figurine = figurine;
	}
}
