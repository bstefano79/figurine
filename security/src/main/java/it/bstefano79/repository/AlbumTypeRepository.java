package it.bstefano79.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.bstefano79.entity.AlbumType;
import it.bstefano79.models.EAlbumType;

public interface AlbumTypeRepository extends JpaRepository<AlbumType, Long>{
	Optional<AlbumType> findByName(EAlbumType name);
	
	@Query(value = "SELECT * FROM albumtypes at WHERE at.name = ?1", nativeQuery = true)
	Optional<AlbumType> findByName(String name);
}
