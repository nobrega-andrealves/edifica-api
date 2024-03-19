package aan.edificaapi.domain.evento;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroEvento(
        Long id,
        @NotNull
        Long igreja_id,
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCriacao,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @FutureOrPresent
        LocalDate dataEvento,
        @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")
        String horaEvento,
        @NotNull
        Boolean ativo
) {
}
