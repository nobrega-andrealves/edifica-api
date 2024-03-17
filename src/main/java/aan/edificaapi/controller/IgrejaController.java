package aan.edificaapi.controller;

import aan.edificaapi.igreja.DadosCadastroIgreja;
import aan.edificaapi.igreja.DadosResultadoPesquisaIgreja;
import aan.edificaapi.igreja.Igreja;
import aan.edificaapi.igreja.IgrejaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("igreja")
public class IgrejaController {

    @Autowired
    private IgrejaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroIgreja dados){

        repository.save(new Igreja(dados));
    }
    @GetMapping
    public List<Igreja> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity recuperarPorId(@PathVariable Long id){

        Optional<Igreja> cadastro = repository.findById(id);

        if (cadastro.isPresent()) {
            Igreja igreja;
            igreja = cadastro.get();
            return ResponseEntity.ok(igreja);
        }
        return ResponseEntity.badRequest().body("Igreja não localizada");
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroIgreja dados) {

        Optional<Igreja> cadastro = repository.findById(dados.id());

        if (cadastro.isPresent()) {
            Igreja igreja;
            igreja = cadastro.get();
            if (igreja.informacoesAtualizadas(dados)){
                return ResponseEntity.ok(igreja);
            } else {
                return ResponseEntity.badRequest().body("Nenhum dado para atualizar");
            }
        }
        return ResponseEntity.badRequest().body("Igreja não localizada");
    }

    @GetMapping("/localizar")
    public ResponseEntity<Page<DadosResultadoPesquisaIgreja>> localizarPorNome(@RequestBody String dadoDeBusca, @PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        var page = repository.localizarPorNome(dadoDeBusca, paginacao).map(DadosResultadoPesquisaIgreja::new);
        return ResponseEntity.ok(page);
    }
}
