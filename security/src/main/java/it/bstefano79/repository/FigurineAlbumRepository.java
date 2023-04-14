package it.bstefano79.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.bstefano79.entity.FigurineAlbum;
import it.bstefano79.idclass.FigurineAlbumId;


public interface FigurineAlbumRepository extends JpaRepository<FigurineAlbum, FigurineAlbumId>{
	
	@Query(value = "SELECT * FROM figurine_album fa WHERE fa.id_album = ?1", nativeQuery = true)
	List<FigurineAlbum> findAllByIdAlbum(int album);
}
