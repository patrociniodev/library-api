package br.com.isaacpatrocinio.library_api.controllers;

import br.com.isaacpatrocinio.library_api.model.Livro;
import br.com.isaacpatrocinio.library_api.services.LivroService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> buscarTodos() {
        var listaLivros = livroService.buscarTodos();
        return ResponseEntity.status(200).body(listaLivros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable UUID id) {
        var livroObj = livroService.buscarPorId(id);
        return ResponseEntity.status(200).body(livroObj);
    }

    @PostMapping()
    public ResponseEntity<Livro> salvarNovoLivro(@RequestBody Livro livroJson, HttpServletRequest request) {
        var livroSalvo = livroService.salvarNovoLivro(livroJson);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(request.getContextPath())
                .buildAndExpand(livroSalvo)
                .toUri();
        return ResponseEntity.created(uri).body(livroSalvo);
    }
}
