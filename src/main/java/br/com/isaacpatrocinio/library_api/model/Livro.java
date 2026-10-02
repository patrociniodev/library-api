package br.com.isaacpatrocinio.library_api.model;

import br.com.isaacpatrocinio.library_api.model.enums.GeneroLivro;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String isbn;
    private String titulo;
    private LocalDate dataPublicacao;
    private GeneroLivro generoLivro;
    private Double preco;

    @ManyToOne(/*cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_autor")
    private Autor autor;
}
