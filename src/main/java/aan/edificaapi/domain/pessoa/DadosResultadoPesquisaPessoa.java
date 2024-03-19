package aan.edificaapi.domain.pessoa;

import java.time.LocalDate;

public record DadosResultadoPesquisaPessoa(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String sexo,
        String nomePerfil,
        String nomeIgreja,
        LocalDate dataInicioMembro,
        String enderecoEmail,
        String numeroTelefone
) {
    public DadosResultadoPesquisaPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(),
                pessoa.getSexo(), pessoa.getPerfil().getNome(), pessoa.getIgreja().getNome(),
                pessoa.getDataInicioMembro(), pessoa.getListaEmail().get(0).getEnderecoEmail(),
                pessoa.getListaTelefone().get(0).getNumeroTelefone()
        );
    }
}
