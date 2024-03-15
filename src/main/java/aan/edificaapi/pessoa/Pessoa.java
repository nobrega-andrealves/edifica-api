package aan.edificaapi.pessoa;

import aan.edificaapi.email.EMail;
import aan.edificaapi.endereco.Endereco;
import aan.edificaapi.igreja.Igreja;
import aan.edificaapi.perfil.Perfil;
import aan.edificaapi.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    private Long id;

    private String nome;

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String sexo;

    private Perfil perfil;

    private Igreja igreja;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @PastOrPresent
    private LocalDate dataInicioMembro;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private EMail email;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Telefone telefone;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Endereco endereco;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
        this.perfil = dados.perfil();
        this.igreja = dados.igreja();
        this.dataInicioMembro = dados.dataInicioMembro();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
    }
}
