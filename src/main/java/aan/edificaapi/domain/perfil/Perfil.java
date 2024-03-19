package aan.edificaapi.domain.perfil;

import jakarta.persistence.*;
import lombok.*;

@Table(name="perfil")
@Entity(name="Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String descricao;
    private Boolean ativo;
}