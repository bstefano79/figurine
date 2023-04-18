package it.bstefano79.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.AlbumWhitFigurineDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.AlbumType;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.repository.AlbumRepository;
import it.bstefano79.repository.AlbumTypeRepository;
import it.bstefano79.repository.FigurineAlbumRepository;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private AlbumTypeRepository albumTypeRepository;
	
	@Autowired
	private FigurineAlbumRepository figurineAlbumRepository;
	
	public List<AlbumDto> findAll() {
		return albumRepository.findAll().stream().map(x -> new AlbumDto(x)).toList();
	}
	
	public List<AlbumWhitFigurineDto> findAllWithFigurines() {
		return albumRepository.findAll().stream().map(x -> new AlbumWhitFigurineDto(x,figurineAlbumRepository.findAllByIdAlbum(x.getId()))).toList();
	}
	
	public AlbumDto findById(Integer id){
		Album album = albumRepository.findById(id).orElse(null);
		if(album==null) return null;
		return new AlbumDto(album);
	}
	
	public AlbumWhitFigurineDto findByIdWithFigurines(Integer id){
		return new AlbumWhitFigurineDto(albumRepository.findById(id).orElse(null),figurineAlbumRepository.findAllByIdAlbum(id));
	}
	
	
	public Optional<AlbumType> findAlbumTypeFromName(String name){
		return albumTypeRepository.findByName(name);
	}
	
	public void newAlbum(AlbumDto albumDto){
		Album album = new Album(albumDto.getName());
		
		List<String> strTypes = albumDto.getTypes();
		Set<AlbumType> types = new HashSet<>();
		
		if (strTypes == null || strTypes.size()==0) {
			//adds in table value default and search
			AlbumType albumType = albumTypeRepository.getTypeDefault()//this.findAlbumTypeFromName("GENERICO")
					.orElseThrow(() -> new FigurineRuntimeException("Error: Album Type is not found."));
			types.add(albumType);
		}else {
			strTypes.forEach(type -> {
				AlbumType albumType = this.findAlbumTypeFromName(type)
						.orElseThrow(() -> new FigurineRuntimeException("Error: Album Type is not found."));
				types.add(albumType);
			});
		}
		album.setTypes(types);
		this.save(album);
	}
	
	public void save(Album album){
		albumRepository.save(album);
	}
}
