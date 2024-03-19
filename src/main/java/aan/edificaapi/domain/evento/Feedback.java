package aan.edificaapi.domain.evento;

import aan.edificaapi.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "feedback")
@Entity(name = "Feedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "evento","pessoa"})
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "evento_id", nullable = false)
    Evento evento;

    @ManyToOne()
    @JoinColumn(name = "pessoa_id", nullable = false)
    Pessoa pessoa;

    short notaEvento;
    String oQueMaisGostou;
    String oQueMenosGostou;
    String outrosComentarios;
    Boolean primeiraVez;
    Boolean indicariaEvento;
    LocalDate dataCriacao;
}