package aan.edificaapi.domain.email;

import jakarta.persistence.*;
import lombok.*;

@Table(name="email")
@Entity(name="EMail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class EMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String enderecoEmail;
    private Boolean ativo;
}
