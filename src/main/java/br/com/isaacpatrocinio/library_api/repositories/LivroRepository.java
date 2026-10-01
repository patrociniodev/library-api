package br.com.isaacpatrocinio.library_api.repositories;

import br.com.isaacpatrocinio.library_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository
        extends JpaRepository<Livro, UUID> {
}
