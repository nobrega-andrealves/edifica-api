package aan.edificaapi.controller;

import aan.edificaapi.domain.evento.DadosCadastroEvento;
import aan.edificaapi.domain.evento.Evento;
import aan.edificaapi.domain.evento.EventoRepository;
import aan.edificaapi.domain.evento.DadosRetornoEvento;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("evento")
@SecurityRequirement(name = "bearer-key")
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEvento dados, UriComponentsBuilder uriBuilder){

        Evento evento = new Evento(dados);
        repository.save(evento);

        var uri = uriBuilder.path("/evento/{id}").buildAndExpand(evento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosRetornoEvento(evento));
    }
    @GetMapping
    public List<Evento> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity recuperarPorId(@PathVariable Long id){

        Optional<Evento> cadastro = repository.findById(id);

        if (cadastro.isPresent()) {
            Evento evento;
            evento = cadastro.get();
            return ResponseEntity.ok(evento);
        }
        return ResponseEntity.badRequest().body("Evento não localizado");
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroEvento dados) {

        Optional<Evento> cadastro = repository.findById(dados.id());

        if (cadastro.isPresent()) {
            Evento evento;
            evento = cadastro.get();
            if (evento.informacoesAtualizadas(dados)){
                return ResponseEntity.ok(evento);
            } else {
                return ResponseEntity.badRequest().body("Nenhum dado para atualizar");
            }
        }
        return ResponseEntity.badRequest().body("Evento não localizado");
    }

    @GetMapping("/localizar")
    public ResponseEntity<Page<Evento>> localizarPorNome(@RequestBody String dadoDeBusca, @PageableDefault(sort = {"nome"}) Pageable paginacao){
        var page = repository.localizarPorNome(dadoDeBusca, paginacao);
        return ResponseEntity.ok(page);
    }
}
