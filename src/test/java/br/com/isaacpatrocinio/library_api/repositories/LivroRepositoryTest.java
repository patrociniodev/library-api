package br.com.isaacpatrocinio.library_api.repositories;

import br.com.isaacpatrocinio.library_api.model.Livro;
import br.com.isaacpatrocinio.library_api.model.enums.GeneroLivro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarNovoLivro() {
//        Livro livro = new Livro();
//        var idAutor = UUID
//                .fromString("1c6ad122-1142-4bbd-a651-1af59ab3ab63");
//        livro.setTitulo("Clean Code");
//        livro.setIsbn("978-8576082675");
//        livro.setDataPublicacao(LocalDate.of(2008, 8, 11));
//        livro.setGeneroLivro(GeneroLivro.TECNICO);
//        livro.setIdAutor(idAutor);
//        livro.setPreco(78.80);

        Livro livro = new Livro();
        var idAutor = UUID
                .fromString("704ae9f8-57dd-4245-8914-07951b731bd1");
        livro.setTitulo("A Game of Thrones");
        livro.setIsbn("978-0553103540");
        livro.setDataPublicacao(LocalDate.of(1996, 8, 1));
        livro.setGeneroLivro(GeneroLivro.FANTASIA);
        livro.setIdAutor(idAutor);
        livro.setPreco(119.90);

        livroRepository.save(livro);
    }

    @Test
    void deletarLivro() {
        var idLivro = UUID.fromString("ed4cb956-8993-43fd-b57b-05dc87b8fb57");
        livroRepository.deleteById(idLivro);
    }
}
