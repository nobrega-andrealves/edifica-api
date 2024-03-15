package aan.edificaapi.controller;

import aan.edificaapi.igreja.Igreja;
import aan.edificaapi.pessoa.DadosCadastroPessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dados){

        repository.save(new Igreja(dados));
    }
}