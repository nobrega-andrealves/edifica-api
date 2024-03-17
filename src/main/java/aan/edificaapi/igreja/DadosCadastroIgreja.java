package aan.edificaapi.igreja;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroIgreja(
        Long id,
        @NotNull
        Long paroquia_id,
        @NotNull
        TipoIgrejaEnum tipoIgreja,
        @NotBlank
        String nome,
        @NotBlank
        String responsavel,
        @Pattern(regexp = "^\\(?([0-9]{2})\\)?( ?)([0-9]{5})\\-?([0-9]{4})$")
        String telefone,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCriacao,
        @NotNull
        StatusIgrejaEnum status) {
}
