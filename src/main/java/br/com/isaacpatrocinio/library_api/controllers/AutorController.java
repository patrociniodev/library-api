package br.com.isaacpatrocinio.library_api.controllers;

import br.com.isaacpatrocinio.library_api.model.Autor;
import br.com.isaacpatrocinio.library_api.services.AutorService;
import br.com.isaacpatrocinio.library_api.services.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

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

    @PostMapping
    public ResponseEntity<Autor> salvarNovoAutor(@RequestBody Autor autorJson) {
        var autorSalvo = autorService.salvarNovoAutor(autorJson);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(autorSalvo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(autorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable UUID id, @RequestBody Autor autorJson) {
        autorService.atualizarAutor(id, autorJson);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> deletar(@PathVariable UUID id) {
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }
}
