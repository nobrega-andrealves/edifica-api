package aan.edificaapi.controller;

import aan.edificaapi.domain.feedback.DadosCadastroFeedback;
import aan.edificaapi.domain.feedback.DadosRetornoFeedback;
import aan.edificaapi.domain.feedback.Feedback;
import aan.edificaapi.domain.feedback.FeedbackRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("feedback")
@SecurityRequirement(name = "bearer-key")
public class FeedbackController {

    @Autowired
    private FeedbackRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity darFeedback(@RequestBody @Valid DadosCadastroFeedback dados, UriComponentsBuilder uriBuilder ){

        Feedback feedback = new Feedback(dados);
        repository.save(feedback);

        var uri = uriBuilder.path("/feedback/{id}").buildAndExpand(feedback.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosRetornoFeedback(feedback));
    }
    @GetMapping
    public List<Feedback> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity recuperarPorId(@PathVariable Long id){

        Optional<Feedback> cadastro = repository.findById(id);

        if (cadastro.isPresent()) {
            Feedback feedback;
            feedback = cadastro.get();
            return ResponseEntity.ok(feedback);
        }
        return ResponseEntity.badRequest().body("Evento não localizado");
    }

    @GetMapping("/evento/{id}")
    public ResponseEntity recuperarPorEventoId(@PathVariable Long id){
        var page = repository.localizarPorEvento(id);
        return ResponseEntity.ok(page);
    }
}