package br.com.isaacpatrocinio.library_api.configuration;

import br.com.isaacpatrocinio.library_api.model.Autor;
import br.com.isaacpatrocinio.library_api.model.Livro;
import br.com.isaacpatrocinio.library_api.model.enums.GeneroLivro;
import br.com.isaacpatrocinio.library_api.repositories.AutorRepository;
import br.com.isaacpatrocinio.library_api.repositories.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("test")
public class DBSeedingConfig implements CommandLineRunner {
    private AutorRepository autorRepository;
    private LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {
        if (autorRepository.count() > 0 || livroRepository.count() > 0) {
            return;
        }

        List<Autor> autorList = List.of(
                new Autor(null, "Robert C. Martin", LocalDate.of(1952, 12, 5), "Americana"),
                new Autor(),
                new Autor()
        );
        List<Livro> livroList = List.of(
                new Livro(null, "978-8576082675", "Clean Code", LocalDate.now(), GeneroLivro.DIDATICO, 78.00, null),
                new Livro(),
                new Livro()
        );

        autorRepository.saveAllAndFlush(autorList);
        livroRepository.saveAllAndFlush(livroList);
    }
}
