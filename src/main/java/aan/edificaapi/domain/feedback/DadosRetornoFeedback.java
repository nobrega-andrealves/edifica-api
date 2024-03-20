package aan.edificaapi.domain.feedback;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record DadosRetornoFeedback(
        Long id,
        short notaEvento,
        String oQueMaisGostou,
        String oQueMenosGostou,
        String outrosComentarios,
        Boolean primeiraVez,
        Boolean indicariaEvento,
        LocalDate dataCriacao
) {
    public DadosRetornoFeedback(Feedback feedback) {
        this(
                feedback.getId(),
                feedback.notaEvento,
                feedback.oQueMaisGostou,
                feedback.oQueMenosGostou,
                feedback.outrosComentarios,
                feedback.getPrimeiraVez(),
                feedback.indicariaEvento,
                feedback.getDataCriacao()
        );
    }
}