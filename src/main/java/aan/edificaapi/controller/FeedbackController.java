package aan.edificaapi.controller;

import aan.edificaapi.domain.evento.Evento;
import aan.edificaapi.domain.feedback.DadosCadastroFeedback;
import aan.edificaapi.domain.feedback.Feedback;
import aan.edificaapi.domain.feedback.FeedbackRepository;
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
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository repository;

    @PostMapping
    @Transactional
    public void darFeedback(@RequestBody @Valid DadosCadastroFeedback dados){

        repository.save(new Feedback(dados));
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