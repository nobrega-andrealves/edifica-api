package aan.edificaapi.domain.evento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoRepository  extends JpaRepository<Evento, Long> {

    @Query(value = """
        SELECT
            E
        FROM
            Evento E
        WHERE
            E.nome like CONCAT(:dadoDeBusca,'%')
    """)
    Page<Evento> localizarPorNome(String dadoDeBusca, Pageable paginacao);
}
