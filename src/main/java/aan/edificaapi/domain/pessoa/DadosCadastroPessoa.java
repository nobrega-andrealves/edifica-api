package aan.edificaapi.domain.pessoa;

import aan.edificaapi.domain.endereco.Endereco;
import aan.edificaapi.domain.telefone.Telefone;
import aan.edificaapi.domain.email.EMail;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DadosCadastroPessoa(
        Long id,
        String nome,
        String cpf,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        String sexo,
        Long idPerfil,
        Long idIgreja,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicioMembro,
        EMail email,
        Telefone telefone,
        Endereco endereco,
        Boolean ativo
) {
}
