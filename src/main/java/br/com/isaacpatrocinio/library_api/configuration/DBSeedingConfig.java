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
                new Autor(),
                new Autor(),
                new Autor(),
                new Autor(),
                new Autor()
        );
        List<Livro> livroList = List.of(
                new Livro(),
                new Livro(),
                new Livro(),
                new Livro(),
                new Livro()
        );

        autorRepository.saveAll(autorList);
        livroRepository.saveAll(livroList);
    }
}
