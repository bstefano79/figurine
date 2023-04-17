package it.bstefano79.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bstefano79.entity.AlbumType;

public interface AlbumTypeRepository extends JpaRepository<AlbumType, Long>{
	Optional<AlbumType> findByName(String name);
}
