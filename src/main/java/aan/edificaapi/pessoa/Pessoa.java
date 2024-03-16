package aan.edificaapi.pessoa;

import aan.edificaapi.email.EMail;
import aan.edificaapi.endereco.Endereco;
import aan.edificaapi.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String sexo;

    private Long idPerfil;

    private Long idIgreja;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @PastOrPresent
    private LocalDate dataInicioMembro;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private List<EMail> listaEmail = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private List<Telefone> listaTelefone = new ArrayList<>();

    private Boolean ativo;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
        this.idPerfil = dados.idPerfil();
        this.idIgreja = dados.idIgreja();
        this.dataInicioMembro = dados.dataInicioMembro();
        this.ativo = dados.ativo();
        this.enderecos.add(dados.endereco());
        this.listaEmail.add(dados.email());
        this.listaTelefone.add(dados.telefone());
    }
}
