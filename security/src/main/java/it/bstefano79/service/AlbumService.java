package it.bstefano79.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.AlbumType;
import it.bstefano79.models.EAlbumType;
import it.bstefano79.repository.AlbumRepository;
import it.bstefano79.repository.AlbumTypeRepository;
import it.bstefano79.repository.FigurineAlbumRepository;
import jakarta.validation.Valid;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private AlbumTypeRepository albumTypeRepository;
	
	@Autowired
	private FigurineAlbumRepository figurineAlbumRepository;
	
	public List<AlbumDto> findAll() {
		return albumRepository.findAll().stream().map(x -> new AlbumDto(x,null)).toList();
	}
	
	public List<AlbumDto> findAllWithFigurines() {
		return albumRepository.findAll().stream().map(x -> new AlbumDto(x,figurineAlbumRepository.findAllByIdAlbum(x.getId()))).toList();
	}
	
	public AlbumDto findById(Integer id){
		
		return new AlbumDto(albumRepository.findById(id).orElse(null),null);
	}
	
	public AlbumDto findByIdWithFigurines(Integer id){
		return new AlbumDto(albumRepository.findById(id).orElse(null),figurineAlbumRepository.findAllByIdAlbum(id));
	}
	
	public Optional<AlbumType> findAlbumTypeFromName(EAlbumType name){
		return albumTypeRepository.findByName(name);
	}
	
	public Optional<AlbumType> findAlbumTypeFromName(String name){
		return this.findAlbumTypeFromName(EAlbumType.getEAlbumTypeFromString(name));
	}
	
	public void newAlbum(AlbumDto albumDto){
		Album album = new Album(albumDto.getName());
		
		List<String> strTypes = albumDto.getTypes();
		Set<AlbumType> types = new HashSet<>();
		
		if (strTypes == null || strTypes.size()==0) {
			AlbumType albumType = this.findAlbumTypeFromName(EAlbumType.GENERICO)
					.orElseThrow(() -> new RuntimeException("Error: Album Type is not found."));
			types.add(albumType);
		}else {
			strTypes.forEach(type -> {
				AlbumType albumType = this.findAlbumTypeFromName(type)
						.orElseThrow(() -> new RuntimeException("Error: Album Type is not found."));
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
