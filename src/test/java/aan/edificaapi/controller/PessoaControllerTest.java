package aan.edificaapi.controller;

import aan.edificaapi.domain.email.EMail;
import aan.edificaapi.domain.endereco.Endereco;
import aan.edificaapi.domain.igreja.*;
import aan.edificaapi.domain.pessoa.DadosCadastroPessoa;
import aan.edificaapi.domain.pessoa.DadosResultadoPesquisaPessoa;
import aan.edificaapi.domain.pessoa.Pessoa;
import aan.edificaapi.domain.pessoa.PessoaRepository;
import aan.edificaapi.domain.telefone.Telefone;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PessoaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroPessoa> dadosCadastroPessoaJson;

    @Autowired
    private JacksonTester<DadosResultadoPesquisaPessoa> dadosResultadoPesquisaPessoaJson;

    @MockBean
    private PessoaRepository pessoaRepository;

    @MockBean
    private IgrejaRepository igrejaRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes de novo cadastro estão inválidas")
    @WithMockUser
    void cadastrar_cenario_01() throws Exception{
        var response = mvc
                .perform(MockMvcRequestBuilders.post("/pessoa"))
                .andReturn().getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informações de novo cadastro estão válidas")
    @WithMockUser
    void cadastrar_cenario_02() throws Exception {

        var igreja = cadastrarIgreja(1L, TipoIgrejaEnum.IGREJA, "IGREJA DE TESTE", "teste", "(21) 00000-0000", LocalDate.of(2024, 3, 22), StatusIgrejaEnum.ATIVA);

        Telefone telefone = new Telefone(null, "(21) 98888-7777", true);
        EMail email = new EMail(null, "teste@teste.com.br", true);
        Endereco endereco = new Endereco(null, "22000000", "rua teste", "8", "teste", "teste", 2L, true);

        var dadosCadastro = new DadosCadastroPessoa(
                null,
                "PESSOA TESTE 01",
                "44444444444",
                LocalDate.of(2000, 12, 24),
                "F",
                5L,
                1L,
                LocalDate.of(2024, 3, 22),
                email,
                telefone,
                endereco,
                true);

        Mockito.when(pessoaRepository.save(ArgumentMatchers.any())).thenReturn(new Pessoa(dadosCadastro));

        var response = mvc
                .perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroPessoaJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        Pessoa pessoa = new Pessoa(dadosCadastro);

        var dadosResultadoPesquisaPessoa = new DadosResultadoPesquisaPessoa(pessoa);
        var jsonEsperado = dadosResultadoPesquisaPessoaJson.write(dadosResultadoPesquisaPessoa).getJson();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    private Igreja cadastrarIgreja(Long paroquia_id, TipoIgrejaEnum tipoIgreja, String nome, String responsavel, String telefone, LocalDate dataCriacao, StatusIgrejaEnum status) {
        DadosCadastroIgreja dados = new DadosCadastroIgreja(null, paroquia_id, tipoIgreja, nome, responsavel, telefone, dataCriacao, status);
        var igreja = new Igreja(dados);
        return igrejaRepository.save(igreja);
    }
}