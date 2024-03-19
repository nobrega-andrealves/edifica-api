package aan.edificaapi.domain.evento;

import aan.edificaapi.domain.igreja.Igreja;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "evento")
@Entity(name = "Evento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "igreja"})
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "igreja_id", nullable = false)
    Igreja igreja;

    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataEvento;
    private String horaEvento;

    boolean ativo;

    public Evento(DadosCadastroEvento dados) {
        this.igreja = new Igreja();
        this.igreja.setId(dados.igreja_id());
        preencherEvento(dados);
    }

    private void preencherEvento(DadosCadastroEvento dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataCriacao = dados.dataCriacao();
        this.dataEvento = dados.dataEvento();
        this.horaEvento = dados.horaEvento();
        this.ativo = dados.ativo();
    }

    public boolean informacoesAtualizadas(DadosCadastroEvento dados) {
        boolean atualizou = false;

        Evento eventoComparacao = new Evento(dados);

        if (!this.equals(eventoComparacao)){
            preencherEvento(dados);
            atualizou = true;
        }
        return atualizou;
    }
}
