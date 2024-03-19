package aan.edificaapi.domain.endereco;

public record DadosCadastroEndereco(
        String cep,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        Long idCidade,
        Boolean ativo
) {
}
