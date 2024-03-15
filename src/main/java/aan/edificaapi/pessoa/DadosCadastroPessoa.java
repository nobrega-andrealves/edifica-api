package aan.edificaapi.pessoa;

import aan.edificaapi.email.EMail;
import aan.edificaapi.endereco.Endereco;
import aan.edificaapi.igreja.Igreja;
import aan.edificaapi.perfil.Perfil;
import aan.edificaapi.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroPessoa(
        String nome,
        String cpf,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        String sexo,
        Perfil perfil,
        Igreja igreja,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicioMembro,
        EMail email,
        Telefone telefone,
        Endereco endereco
) {
}
