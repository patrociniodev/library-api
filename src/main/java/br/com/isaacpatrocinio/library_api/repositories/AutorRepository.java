package br.com.isaacpatrocinio.library_api.repositories;

import br.com.isaacpatrocinio.library_api.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository
        extends JpaRepository<Autor, UUID> {
}
