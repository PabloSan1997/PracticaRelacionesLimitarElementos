package com.practica.relaciones.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.practica.relaciones.entities.Libro;
import com.practica.relaciones.entities.dto.LibroDto;


public interface LibroRepository extends CrudRepository<Libro, Long>{

    @Query("SELECT l FROM Libro l")
    List<Libro> findAllLimitsxd(Pageable pageable);

    @Query("SELECT new com.practica.relaciones.entities.dto.LibroDto(l.id, l.name, l.totalPages) FROM Libro l WHERE l.autor.id = ?1 ORDER BY l.id desc")
    List<LibroDto> findByAutorxd(Long autor, Pageable pageable);
}
