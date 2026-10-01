package br.com.isaacpatrocinio.library_api.repositories;

import br.com.isaacpatrocinio.library_api.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class AutorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    void salvarNovoAutor() {
//        Autor autor = new Autor();
//        autor.setNome("Robert C. Martin");
//        autor.setDataNascimento(LocalDate.now());
//        autor.setNacionalidade("Americana");

        Autor autor = new Autor();
        autor.setNome("George R. R. Martin");
        autor.setDataNascimento(LocalDate.of(1948, 9, 20));
        autor.setNacionalidade("Americana");

        autorRepository.save(autor);
    }

    @Test
    void deletarAutor() {
        var idAutor = UUID.fromString("2aa36c5a-77ee-44ab-bfa6-64cd98986de0");
        autorRepository.deleteById(idAutor);
    }
}
