package com.practica.relaciones.entities.dto;

import lombok.Getter;
import lombok.Setter;

public class LibroDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Integer totalPages;

    public LibroDto(Long id, String name, Integer totalPages) {
        this.id = id;
        this.name = name;
        this.totalPages = totalPages;
    }


    
}
