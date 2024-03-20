package aan.edificaapi.controller;

import aan.edificaapi.domain.evento.DadosRetornoEvento;
import aan.edificaapi.domain.evento.Evento;
import aan.edificaapi.domain.pessoa.DadosCadastroPessoa;
import aan.edificaapi.domain.pessoa.DadosResultadoPesquisaPessoa;
import aan.edificaapi.domain.pessoa.Pessoa;
import aan.edificaapi.domain.pessoa.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){

        Pessoa pessoa = new Pessoa(dados);
        repository.save(pessoa);
        var uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosResultadoPesquisaPessoa(pessoa));
    }
    @GetMapping
    public List<Pessoa> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity recuperarPorId(@PathVariable Long id){

        Optional<Pessoa> cadastro = repository.findById(id);

        if (cadastro.isPresent()) {
            Pessoa pessoa;
            pessoa = cadastro.get();
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.badRequest().body("Pessoa não localizada");
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroPessoa dados) {

        Optional<Pessoa> cadastro = repository.findById(dados.id());

        if (cadastro.isPresent()) {
            Pessoa pessoa;
            pessoa = cadastro.get();
            if (pessoa.informacoesAtualizadas(dados)){
                return ResponseEntity.ok(pessoa);
            } else {
                return ResponseEntity.badRequest().body("Nenhum dado para atualizar");
            }
        }
        return ResponseEntity.badRequest().body("Pessoa não localizada");
    }

    @GetMapping("/localizar")
    public ResponseEntity<Page<DadosResultadoPesquisaPessoa>> localizarPorNome(@RequestBody String dadoDeBusca, @PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        var page = repository.localizarPorNome(dadoDeBusca, paginacao).map(DadosResultadoPesquisaPessoa::new);
        return ResponseEntity.ok(page);
    }
}