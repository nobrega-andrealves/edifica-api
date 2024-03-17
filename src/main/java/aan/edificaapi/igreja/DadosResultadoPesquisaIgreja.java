package aan.edificaapi.igreja;

import jakarta.persistence.*;

import java.time.LocalDate;

public record DadosResultadoPesquisaIgreja(
        Long id,
        String nomeParoquia,
        TipoIgrejaEnum tipoIgreja,
        String nome,
        String responsavel,
        String telefone,
        LocalDate dataCriacao,
        StatusIgrejaEnum status
) {

    public DadosResultadoPesquisaIgreja(Igreja igreja) {
        this(
                igreja.getId(), igreja.getParoquia().getNome(), igreja.getTipoIgreja(),
                igreja.getNome(), igreja.getResponsavel(), igreja.getTelefone(),
                igreja.getDataCriacao(), igreja.getStatus()
        );
    }
}