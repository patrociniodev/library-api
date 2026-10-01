package br.com.isaacpatrocinio.library_api.controllers;

import br.com.isaacpatrocinio.library_api.model.Autor;
import br.com.isaacpatrocinio.library_api.services.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> buscarTodos() {
        var listaAutores = autorService.buscarTodos();
        return ResponseEntity.status(200).body(listaAutores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable UUID id) {
        var autor = autorService.buscarPorId(id);
        return ResponseEntity.status(200).body(autor);
    }
}
