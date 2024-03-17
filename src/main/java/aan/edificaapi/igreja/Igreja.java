package aan.edificaapi.igreja;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "igreja")
@Entity(name = "Igreja")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Igreja {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paroquia_id;
    @Enumerated(EnumType.STRING)
    private TipoIgrejaEnum tipoIgreja;
    private String nome;
    private String responsavel;
    private String telefone;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusIgrejaEnum status;

    public Igreja(DadosCadastroIgreja dados) {
        this.paroquia_id = dados.paroquia_id();
        this.tipoIgreja = dados.tipoIgreja();
        this.nome = dados.nome();
        this.responsavel = dados.responsavel();
        this.telefone = dados.telefone();
        this.dataCriacao = dados.dataCriacao();
        this.status = dados.status();
    }
}
