package com.practica.relaciones.entities.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class AutorDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private Integer edad;
    
    @Getter @Setter
    private List<LibroDto> libros;

    public AutorDto(Long id, String nombre, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    
}
