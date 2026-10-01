package br.com.isaacpatrocinio.library_api.services;

import br.com.isaacpatrocinio.library_api.model.Autor;
import br.com.isaacpatrocinio.library_api.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> buscarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(UUID id) {
        var possivelAutor = autorRepository.findById(id);
        return possivelAutor.orElseThrow(() -> {
            throw new RuntimeException("Id não encontrado");
        });
    }
}
