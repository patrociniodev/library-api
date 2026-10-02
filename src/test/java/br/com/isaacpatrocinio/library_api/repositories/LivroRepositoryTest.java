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
//                .fromString("e8178f2c-381a-4160-a31f-a2c69c43ab05");
//        var autorObj = autorRepository.findById(idAutor).get();
//        livro.setTitulo("Clean Code");
//        livro.setIsbn("978-8576082675");
//        livro.setDataPublicacao(LocalDate.of(2008, 8, 11));
//        livro.setGeneroLivro(GeneroLivro.TECNICO);
//        livro.setIdAutor(autorObj);
//        livro.setPreco(78.80);

        Livro livro = new Livro();
        var idAutor = UUID
                .fromString("be688bbd-4faf-4df9-ab7a-855c3d28f01d");
        var autorObj = autorRepository.findById(idAutor).get();
        livro.setTitulo("A Game of Thrones");
        livro.setIsbn("978-0553103540");
        livro.setDataPublicacao(LocalDate.of(1996, 8, 1));
        livro.setGeneroLivro(GeneroLivro.FANTASIA);
        livro.setAutor(autorObj);
        livro.setPreco(119.90);

        livroRepository.save(livro);
    }

    @Test
    void deletarLivro() {
        var idLivro = UUID.fromString("ec5e267d-b85e-4858-ab6a-f6d3b8394e2b");
        livroRepository.deleteById(idLivro);
    }

    @Test
    void atualizarLivro() {
        var idLivro = UUID.fromString("a2fb274b-4a84-4f52-8032-568547a5f171");
        if (!livroRepository.existsById(idLivro)) {
            throw new RuntimeException("Id não encontrado.");
        }
        var livroObj = livroRepository.findById(idLivro).get();
        System.out.print("Livro encontrado: ");
        System.out.println(livroObj.toString());
        livroObj.setPreco(79.99);

        livroRepository.save(livroObj);
    }

    @Test
    void listarLivros() {
        var listaLivros = livroRepository.findAll();
        for (Livro livro : listaLivros) {
            System.out.println(livro.toString());
        }
    }

    @Test
    void contarRegistrosLivros() {
        System.out.println(livroRepository.count() + " registros encontrados no banco de dados.");
    }
}
