package aan.edificaapi.igreja;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroIgreja(
        @NotNull
        TipoIgrejaEnum tipoIgreja,
        @NotBlank
        String nome,
        @NotBlank
        String responsavel,
        @Pattern(regexp = "^((\\(\\d{2,3}[ -]?\\))|\\d{9})$")
        String telefone,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCriacao,
        @NotNull
        StatusIgrejaEnum status) {
}
