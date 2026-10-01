package br.com.isaacpatrocinio.library_api.services;

import br.com.isaacpatrocinio.library_api.model.Livro;
import br.com.isaacpatrocinio.library_api.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(UUID id) {
        var possivelLivro = livroRepository.findById(id);
        return possivelLivro.orElseThrow(() -> {
            throw new RuntimeException("Id não encontrado.");
        });
    }
}
