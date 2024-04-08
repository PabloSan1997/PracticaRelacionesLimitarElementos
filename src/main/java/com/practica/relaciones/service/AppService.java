package com.practica.relaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.practica.relaciones.entities.Autor;
import com.practica.relaciones.entities.Libro;
import com.practica.relaciones.entities.dto.AutorDto;
import com.practica.relaciones.entities.dto.LibroDto;
import com.practica.relaciones.repositories.AutorRepository;
import com.practica.relaciones.repositories.LibroRepository;

@Service
public class AppService {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<?> readLibros() {
        return libroRepository.findAllLimitsxd(PageRequest.of(0, 2));
    }

    public List<?> readAutores() {
        return (List<?>) autorRepository.findAll();
    }

    public Autor addAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public AutorDto findAutorById(Long id, int page){
        Optional<Autor> opAutor = autorRepository.findById(id);
        if(opAutor.isEmpty()) return null;
        Autor autor = opAutor.orElseThrow();
        List<LibroDto> libros =  libroRepository.findByAutorxd(id, PageRequest.of(page, 2));
        AutorDto autorDto = new AutorDto(id, autor.getNombre(), autor.getEdad());
        autorDto.setLibros(libros);
        return autorDto;
    }

    public Libro addLibro(Long id_autor, Libro libro){
        Optional<Autor> opAutor = autorRepository.findById(id_autor);
        if(opAutor.isEmpty()) return null;
        Autor autor = opAutor.orElseThrow();
        libro.setAutor(autor);
        return libroRepository.save(libro);
    }

}
