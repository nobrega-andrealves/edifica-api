package aan.edificaapi.domain.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DadosResumoFeedback {
    private Long quantidadePessoasFeedback;
    private double notaMediaEvento;
    private Long quantidadePessoasPrimeiraVez;
    private Long quantidadePessoasIndicariaEvento;

    public DadosResumoFeedback(Long quantidadePessoasFeedback, double notaMediaEvento, Long quantidadePessoasPrimeiraVez, Long quantidadePessoasIndicariaEvento) {
        this.quantidadePessoasFeedback = quantidadePessoasFeedback;
        this.notaMediaEvento = notaMediaEvento;
        this.quantidadePessoasPrimeiraVez = quantidadePessoasPrimeiraVez;
        this.quantidadePessoasIndicariaEvento = quantidadePessoasIndicariaEvento;
    }

    public Long getQuantidadePessoasFeedback() {
        return quantidadePessoasFeedback;
    }

    public void setQuantidadePessoasFeedback(Long quantidadePessoasFeedback) {
        this.quantidadePessoasFeedback = quantidadePessoasFeedback;
    }

    public double getNotaMediaEvento() {
        return notaMediaEvento;
    }

    public void setNotaMediaEvento(double notaMediaEvento) {
        this.notaMediaEvento = notaMediaEvento;
    }

    public Long getQuantidadePessoasPrimeiraVez() {
        return quantidadePessoasPrimeiraVez;
    }

    public void setQuantidadePessoasPrimeiraVez(Long quantidadePessoasPrimeiraVez) {
        this.quantidadePessoasPrimeiraVez = quantidadePessoasPrimeiraVez;
    }

    public Long getQuantidadePessoasIndicariaEvento() {
        return quantidadePessoasIndicariaEvento;
    }

    public void setQuantidadePessoasIndicariaEvento(Long quantidadePessoasIndicariaEvento) {
        this.quantidadePessoasIndicariaEvento = quantidadePessoasIndicariaEvento;
    }
}
