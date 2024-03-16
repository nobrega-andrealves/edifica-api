package aan.edificaapi.telefone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="telefone")
@Entity(name="Telefone")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String numeroTelefone;
    private Boolean ativo;
}