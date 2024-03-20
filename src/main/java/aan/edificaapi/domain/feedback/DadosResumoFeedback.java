package aan.edificaapi.domain.feedback;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DadosResumoFeedback {
    private Long evento_id;
    private String nomeEvento;
    private LocalDate dataEvento;
    private Long quantidadePessoasFeedback;
    private double notaMediaEvento;
    private Long quantidadePessoasPrimeiraVez;
    private Long quantidadePessoasIndicariaEvento;
    private double percentualPessoasIndicacao;

    public DadosResumoFeedback(
            Long evento_id,
            String nomeEvento,
            LocalDate dataEvento,
            Long quantidadePessoasFeedback,
            double notaMediaEvento,
            Long quantidadePessoasPrimeiraVez,
            Long quantidadePessoasIndicariaEvento
    ) {
        this.evento_id = evento_id;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.quantidadePessoasFeedback = quantidadePessoasFeedback;
        this.notaMediaEvento = notaMediaEvento;
        this.quantidadePessoasPrimeiraVez = quantidadePessoasPrimeiraVez;
        this.quantidadePessoasIndicariaEvento = quantidadePessoasIndicariaEvento;
        this.percentualPessoasIndicacao = (quantidadePessoasIndicariaEvento.doubleValue() / quantidadePessoasFeedback.doubleValue()) * 100;
    }
}
