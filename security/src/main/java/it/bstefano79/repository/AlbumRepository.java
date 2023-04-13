package it.bstefano79.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bstefano79.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{
	Optional<Album> findByName(String name);
	
	List<Album> findAll();
}
