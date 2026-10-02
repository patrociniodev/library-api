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

//        Autor autor = new Autor();
//        autor.setNome("George R. R. Martin");
//        autor.setDataNascimento(LocalDate.of(1948, 9, 20));
//        autor.setNacionalidade("Americana");

        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setDataNascimento(LocalDate.of(1951, 6, 12));
        autor.setNacionalidade("Brasileira");

        autorRepository.save(autor);
    }

    @Test
    void atualizarAutor() {
        var idAutor = UUID.fromString("050eba28-6b2a-4737-9991-979b8a8454ac");
        if (!autorRepository.existsById(idAutor)) {
            throw new RuntimeException("Id não encontrado.");
        }

        var objAutor = autorRepository.findById(idAutor).get();
        System.out.println("Autor encontrado: " + objAutor.toString());
        objAutor.setNome("Glória Maria");
        objAutor.setDataNascimento(LocalDate.of(1955, 1, 12));

        autorRepository.save(objAutor);
    }

    @Test
    void deletarAutor() {
        var idAutor = UUID.fromString("2aa36c5a-77ee-44ab-bfa6-64cd98986de0");
        autorRepository.deleteById(idAutor);
    }

    @Test
    void listarAutores() {
        var listaAutores = autorRepository.findAll();
        for (Autor autor : listaAutores) {
            System.out.println(autor.toString());
        }
    }

    @Test
    void contarRegistrosAutores() {
        System.out.println(autorRepository.count() + " registros encontrados no banco de dados.");
    }
}
