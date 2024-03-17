package aan.edificaapi.pessoa;

import aan.edificaapi.email.EMail;
import aan.edificaapi.endereco.Endereco;
import aan.edificaapi.igreja.Igreja;
import aan.edificaapi.perfil.Perfil;
import aan.edificaapi.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id","enderecos", "listaEmail", "listaTelefone"})
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String sexo;

    @ManyToOne()
    @JoinColumn(name = "idPerfil", nullable = false)
    private Perfil perfil;

    @ManyToOne()
    @JoinColumn(name = "idIgreja", nullable = false)
    private Igreja igreja;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @PastOrPresent
    private LocalDate dataInicioMembro;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @SQLRestriction("ativo = 1")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @SQLRestriction("ativo = 1")
    private List<EMail> listaEmail = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @SQLRestriction("ativo = 1")
    private List<Telefone> listaTelefone = new ArrayList<>();

    private Boolean ativo;

    public Pessoa(DadosCadastroPessoa dados) {
        preencherPessoa(dados);
        this.enderecos.add(dados.endereco());
        this.listaEmail.add(dados.email());
        this.listaTelefone.add(dados.telefone());
    }

    private void preencherPessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
        this.perfil = new Perfil();
        this.perfil.setId(dados.idPerfil());
        this.igreja = new Igreja();
        this.igreja.setId(dados.idIgreja());
        this.dataInicioMembro = dados.dataInicioMembro();
        this.ativo = dados.ativo();
    }

    public boolean informacoesAtualizadas(DadosCadastroPessoa dados) {

        boolean atualizou = false;

        Pessoa pessoaComparacao = new Pessoa(dados);

        if (!this.equals(pessoaComparacao)){
            preencherPessoa(dados);
            atualizou = true;
        }

        if (dados.endereco() != null && !dados.endereco().equals(this.enderecos.get(0))) {
            this.enderecos.get(0).setAtivo(false);
            this.enderecos.add(dados.endereco());
            atualizou = true;
        }

        if (dados.telefone() != null && !dados.telefone().equals(this.listaTelefone.get(0))) {
            this.listaTelefone.get(0).setAtivo(false);
            this.listaTelefone.add(dados.telefone());
            atualizou = true;
        }

        if (dados.email() != null && !dados.email().equals(this.listaEmail.get(0))) {
            this.listaEmail.get(0).setAtivo(false);
            this.listaEmail.add(dados.email());
            atualizou = true;
        }
        return atualizou;
    }
}
