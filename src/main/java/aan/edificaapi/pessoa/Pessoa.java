package aan.edificaapi.pessoa;

import aan.edificaapi.email.EMail;
import aan.edificaapi.endereco.Endereco;
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

    /*@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)*/

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

    public boolean informacoesAtualizadas(DadosCadastroPessoa dados) {
        boolean atualizou = false;
        if (dados.nome() != null && !dados.nome().equals(this.nome)) {
            this.nome = dados.nome();
            atualizou = true;
        }
        if (dados.dataNascimento() != null && !dados.dataNascimento().equals(this.dataNascimento)) {
            this.dataNascimento = dados.dataNascimento();
            atualizou = true;
        }

        if (dados.sexo() != null && !dados.sexo().equals(this.sexo)) {
            this.sexo = dados.sexo();
            atualizou = true;
        }

        if (dados.idPerfil() != null && !dados.idPerfil().equals(this.idPerfil)) {
            this.idPerfil = dados.idPerfil();
            atualizou = true;
        }

        if (dados.idIgreja() != null && !dados.idIgreja().equals(this.idIgreja)) {
            this.idIgreja = dados.idIgreja();
            atualizou = true;
        }

        if (dados.dataInicioMembro() != null && !dados.dataInicioMembro().equals(this.dataInicioMembro)) {
            this.dataInicioMembro = dados.dataInicioMembro();
            atualizou = true;
        }

        if (dados.ativo() != null && !dados.ativo().equals(this.ativo)) {
            this.ativo = dados.ativo();
            atualizou = true;
        }

        if (dados.endereco() != null && !dados.endereco().equals(this.enderecos.get(0))) {
            this.enderecos.get(0).setAtivo(false);
            this.enderecos.add(dados.endereco());
            atualizou = true;
        }
/*
        this.listaEmail.add(dados.email());
        this.listaTelefone.add(dados.telefone());*/
        return atualizou;
    }
}
