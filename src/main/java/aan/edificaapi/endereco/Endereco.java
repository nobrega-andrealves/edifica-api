package aan.edificaapi.endereco;

import aan.edificaapi.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

@Table(name="endereco")
@Entity(name="Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Long idCidade;
    private Boolean ativo;

    public Endereco(DadosCadastroEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.idCidade = dados.idCidade();
        this.ativo = dados.ativo();
    }

    public void atualizarInformacoes(DadosCadastroEndereco dados) {
        if (dados.cep() != null) this.cep = dados.cep();
        if (dados.logradouro() != null) this.logradouro = dados.logradouro();
        if (dados.numero() != null) this.numero = dados.numero();
        if (dados.complemento() != null) this.complemento = dados.complemento();
        if (dados.bairro() != null) this.bairro = dados.bairro();
        if (dados.idCidade() != null) this.idCidade = dados.idCidade();
    }
}
