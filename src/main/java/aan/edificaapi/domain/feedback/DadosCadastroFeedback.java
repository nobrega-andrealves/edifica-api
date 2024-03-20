package aan.edificaapi.domain.feedback;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

public record DadosCadastroFeedback(
        Long id,
        @NotNull
        Long evento_id,
        @NotNull
        Long pessoa_id,
        @Range(min = 1,max = 10)
        short notaEvento,
        @Size(min = 2, message = "{validation.name.size.too_short}")
        @Size(max = 400, message = "{validation.name.size.too_long}")
        String oQueMaisGostou,
        @Size(min = 2, message = "{validation.name.size.too_short}")
        @Size(max = 400, message = "{validation.name.size.too_long}")
        String oQueMenosGostou,
        @Size(min = 2, message = "{validation.name.size.too_short}")
        @Size(max = 400, message = "{validation.name.size.too_long}")
        String outrosComentarios,
        Boolean primeiraVez,
        Boolean indicariaEvento,
        LocalDate dataCriacao
) {
}
