package aan.edificaapi.domain.feedback;

import aan.edificaapi.domain.evento.Evento;
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

    public Feedback(DadosCadastroFeedback dados) {
        this.evento = new Evento();
        this.evento.setId(dados.evento_id());
        this.pessoa = new Pessoa();
        this.pessoa.setId(dados.pessoa_id());
        preencherFeedback(dados);
    }

    private void preencherFeedback(DadosCadastroFeedback dados) {
        this.notaEvento = dados.notaEvento();
        this.oQueMaisGostou = dados.oQueMaisGostou();
        this.oQueMenosGostou = dados.oQueMenosGostou();
        this.outrosComentarios = dados.outrosComentarios();
        this.primeiraVez = dados.primeiraVez();
        this.indicariaEvento = dados.indicariaEvento();
        this.dataCriacao = dados.dataCriacao();
    }
}