package aan.edificaapi.email;

import aan.edificaapi.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="email")
@Entity(name="EMail")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String enderecoEmail;
    private Boolean ativo;
}
