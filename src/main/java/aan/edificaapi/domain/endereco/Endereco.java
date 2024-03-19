package aan.edificaapi.domain.endereco;

import jakarta.persistence.*;
import lombok.*;

@Table(name="endereco")
@Entity(name="Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Long idCidade;
    private Boolean ativo;
}
