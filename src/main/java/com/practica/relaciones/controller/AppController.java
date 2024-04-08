package com.practica.relaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practica.relaciones.entities.Autor;
import com.practica.relaciones.entities.Libro;
import com.practica.relaciones.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class AppController {
    
    @Autowired
    private AppService appService;

    @GetMapping("/libro")
    public ResponseEntity<?> getLibros() {
        var data = appService.readLibros();
        return ResponseEntity.ok().body(data);
    }
    
    @GetMapping("/autor")
    public ResponseEntity<?> getAutor() {
        var data = appService.readAutores();
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<?> getIdAutor(@PathVariable Long id, @RequestParam int page) {
        var data = appService.findAutorById(id, page);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/autor")
    public ResponseEntity<?> postAutor(@RequestBody Autor autor){
        var data = appService.addAutor(autor);
        return ResponseEntity.status(201).body(data);
    }

    @PostMapping("/libro/{id}")
    public ResponseEntity<?> postLibro(@RequestBody Libro libro, @PathVariable Long id){
        var data = appService.addLibro(id, libro);
        return ResponseEntity.status(201).body(data);
    }
}
