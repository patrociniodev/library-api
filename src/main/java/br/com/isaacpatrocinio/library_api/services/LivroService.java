package br.com.isaacpatrocinio.library_api.services;

import br.com.isaacpatrocinio.library_api.model.Livro;
import br.com.isaacpatrocinio.library_api.repositories.LivroRepository;
import br.com.isaacpatrocinio.library_api.services.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorId(UUID id) {
        var possivelLivro = livroRepository.findById(id);
        return possivelLivro.orElseThrow(() ->
                new NotFoundException("Id não encontrado.")
        );
    }

    public Livro salvarNovoLivro(Livro livro) {
        if (livro == null) {
            throw new NotFoundException("Ocorreu um erro ao processar a solicitação.");
        }
        return livroRepository.save(livro);
    }
}
