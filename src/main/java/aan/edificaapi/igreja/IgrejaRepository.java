package aan.edificaapi.igreja;

import aan.edificaapi.pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IgrejaRepository extends JpaRepository<Igreja, Long> {

    // """ é para quebrar linha sem precisar utilizar o + para concatenar
    @Query(value = """
        SELECT
            I
        FROM
            Igreja I
        WHERE
            I.nome like CONCAT(:dadoDeBusca,'%')
    """)
    Page<Igreja> localizarPorNome(String dadoDeBusca, Pageable paginacao);
}
