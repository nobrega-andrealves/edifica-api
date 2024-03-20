package aan.edificaapi.domain.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FeedbackRepository  extends JpaRepository<Feedback, Long> {
    @Query(value = """
        SELECT
            new aan.edificaapi.domain.feedback.DadosResumoFeedback(
                F.id AS evento_id,
                E.nome AS nomeEvento, E.dataEvento,
                count(1) AS quantidadePessoasFeedback,
                avg(F.notaEvento) AS notaMediaEvento,
                count(case when F.primeiraVez = true then 1 else null end) AS quantidadePessoasPrimeiraVez,
                count(case when F.indicariaEvento = true then 1 else null end) AS quantidadePessoasIndicariaEvento
            )
        FROM
            Evento E
            INNER JOIN Feedback F ON (E.id = F.evento.id)
        WHERE
            E.id = :evento_id
    """)
    Optional<DadosResumoFeedback> localizarPorEvento(Long evento_id);
}