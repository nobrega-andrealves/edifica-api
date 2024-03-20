package aan.edificaapi.domain.evento;

import aan.edificaapi.domain.evento.Evento;
import aan.edificaapi.domain.igreja.Igreja;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record DadosRetornoEvento(Long id, String nome, String descricao, LocalDate dataCriacao, LocalDate dataEvento, String horaEvento) {

    public DadosRetornoEvento(Evento evento){
        this(evento.getId(), evento.getNome(), evento.getDescricao(), evento.getDataCriacao(), evento.getDataEvento(), evento.getHoraEvento());
    }
}
