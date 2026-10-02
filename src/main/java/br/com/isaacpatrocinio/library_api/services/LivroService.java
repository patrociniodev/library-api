package br.com.isaacpatrocinio.library_api.services;

import br.com.isaacpatrocinio.library_api.model.Livro;
import br.com.isaacpatrocinio.library_api.repositories.LivroRepository;
import br.com.isaacpatrocinio.library_api.services.exceptions.LibraryException;
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
            throw new LibraryException("Ocorreu um erro ao processar a solicitação.");
        }
        return livroRepository.save(livro);
    }

    public void atualizarLivro(UUID uuid, Livro livroJson) {
        if (livroJson == null) {
            throw new LibraryException("Ocorreu um erro ao processar a solicitação.");
        }

        var livroOptional = livroRepository.findById(uuid);
        if (livroOptional.isEmpty()){
            throw new NotFoundException("Livro não encontrado.");
        }

        var livroObj = livroOptional.get();
        livroObj.setId(uuid);
        if (livroJson.getTitulo() != null) livroObj.setTitulo(livroJson.getTitulo());
        if (livroJson.getIsbn() != null) livroObj.setIsbn(livroJson.getIsbn());
        if (livroJson.getDataPublicacao() != null) livroObj.setDataPublicacao(livroJson.getDataPublicacao());
        if (livroJson.getGeneroLivro() != null) livroObj.setGeneroLivro(livroJson.getGeneroLivro());
        if (livroJson.getPreco() != null) livroObj.setPreco(livroJson.getPreco());

        livroRepository.save(livroObj);
    }

    public void deletarLivro(UUID id) {
        livroRepository.deleteById(id);
    }
}
