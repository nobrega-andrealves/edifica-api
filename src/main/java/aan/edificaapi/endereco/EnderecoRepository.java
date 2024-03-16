package aan.edificaapi.endereco;

import aan.edificaapi.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Pessoa, Long>{
}
