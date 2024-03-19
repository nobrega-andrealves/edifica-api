package aan.edificaapi.domain.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    // """ é para quebrar linha sem precisar utilizar o + para concatenar
    @Query(value = """
        SELECT
            P
        FROM
            Pessoa P
        WHERE
            P.ativo = true
            AND P.nome like CONCAT(:dadoDeBusca,'%')
    """)
    Page<Pessoa> localizarPorNome(String dadoDeBusca, Pageable paginacao);
}