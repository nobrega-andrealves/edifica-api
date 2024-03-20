package aan.edificaapi.domain.feedback;

public record DadosRetornoFeedback(
        Long quantidadePessoasFeedback,
        Float notaMediaEvento,
        Long quantidadePessoasPrimeiraVez,
        Long quantidadePessoasIndicariaEvento
) {
    public DadosRetornoFeedback(Long quantidadePessoasFeedback, Float notaMediaEvento, Long quantidadePessoasPrimeiraVez, Long quantidadePessoasIndicariaEvento) {
        this.quantidadePessoasFeedback = quantidadePessoasFeedback;
        this.notaMediaEvento = notaMediaEvento;
        this.quantidadePessoasPrimeiraVez = quantidadePessoasPrimeiraVez;
        this.quantidadePessoasIndicariaEvento = quantidadePessoasIndicariaEvento;
    }
}
