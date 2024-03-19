package aan.edificaapi.domain.igreja;

import aan.edificaapi.domain.paroquia.Paroquia;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "igreja")
@Entity(name = "Igreja")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "paroquia"})
public class Igreja {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "paroquia_id", nullable = false)
    Paroquia paroquia;

    @Enumerated(EnumType.STRING)
    private TipoIgrejaEnum tipoIgreja;
    private String nome;
    private String responsavel;
    private String telefone;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusIgrejaEnum status;

    public Igreja(DadosCadastroIgreja dados) {
        this.paroquia = new Paroquia();
        this.paroquia.setId(dados.paroquia_id());
        preencherIgreja(dados);
    }

    private void preencherIgreja(DadosCadastroIgreja dados) {
        this.tipoIgreja = dados.tipoIgreja();
        this.nome = dados.nome();
        this.responsavel = dados.responsavel();
        this.telefone = dados.telefone();
        this.dataCriacao = dados.dataCriacao();
        this.status = dados.status();
    }

    public boolean informacoesAtualizadas(DadosCadastroIgreja dados) {
        boolean atualizou = false;

        Igreja igrejaComparacao = new Igreja(dados);

        if (!this.equals(igrejaComparacao)){
            preencherIgreja(dados);
            atualizou = true;
        }
        return atualizou;        
    }
}
