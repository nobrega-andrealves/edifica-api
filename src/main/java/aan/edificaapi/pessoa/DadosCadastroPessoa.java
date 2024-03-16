package aan.edificaapi.pessoa;

import aan.edificaapi.email.EMail;
import aan.edificaapi.endereco.Endereco;
import aan.edificaapi.telefone.Telefone;
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
