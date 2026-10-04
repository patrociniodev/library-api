package br.com.isaacpatrocinio.library_api.services;

import br.com.isaacpatrocinio.library_api.model.Autor;
import br.com.isaacpatrocinio.library_api.repositories.AutorRepository;
import br.com.isaacpatrocinio.library_api.services.exceptions.LibraryException;
import br.com.isaacpatrocinio.library_api.services.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> buscarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(UUID id) {
        var possivelAutor = autorRepository.findById(id);
        return possivelAutor.orElseThrow(() ->
                new NotFoundException("Id não encontrado")
        );
    }

    public Autor salvarNovoAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void atualizarAutor(UUID uuid, Autor autorJson) {
        var autorOptional = autorRepository.findById(uuid);
        if (autorOptional.isEmpty()) {
            throw new NotFoundException("Id não encontrado.");
        }

        var autorObj = autorOptional.get();
        autorObj.setId(uuid);
        if (autorJson.getNome() != null) autorObj.setNome(autorJson.getNome());
        if (autorJson.getDataNascimento() != null) autorObj.setDataNascimento(autorJson.getDataNascimento());
        if (autorJson.getNacionalidade() != null) autorObj.setNacionalidade(autorJson.getNacionalidade());
        if (autorJson.getLivros() != null) autorObj.setLivros(autorJson.getLivros());

        autorRepository.save(autorObj);
    }

    public void deletarAutor(UUID id) {
        autorRepository.deleteById(id);
    }
}
