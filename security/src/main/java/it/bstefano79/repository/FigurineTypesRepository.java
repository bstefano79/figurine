package it.bstefano79.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.bstefano79.entity.FigurineTypes;

@Repository
public interface FigurineTypesRepository extends JpaRepository<FigurineTypes, String>{
	
	@Query("SELECT f FROM FigurineTypes f WHERE f.type_default=true")
	Optional<FigurineTypes> getTypeDefault();
}
