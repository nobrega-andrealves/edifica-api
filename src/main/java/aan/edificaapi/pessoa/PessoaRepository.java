package aan.edificaapi.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    //usei o JPQL do JPA para escrever a query
    // """ é para quebrar linha sem precisar utilizar o + para concatenar
    @Query("""
        SELECT
            P
        FROM
            Pessoa P
        WHERE
            ativo = true
            AND nome like CONCAT(:dadoDeBusca,'%')
    """)
    List<Pessoa> localizarPorNome(String dadoDeBusca);
}