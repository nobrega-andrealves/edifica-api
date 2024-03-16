package aan.edificaapi.telefone;

import jakarta.persistence.*;
import lombok.*;

@Table(name="telefone")
@Entity(name="Telefone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String numeroTelefone;
    private Boolean ativo;
}