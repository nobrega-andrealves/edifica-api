package aan.edificaapi.paroquia;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Table(name = "paroquia")
@Entity(name = "Paroquia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Paroquia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
}
