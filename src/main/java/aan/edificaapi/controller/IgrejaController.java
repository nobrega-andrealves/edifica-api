package aan.edificaapi.controller;

import aan.edificaapi.igreja.DadosCadastroIgreja;
import aan.edificaapi.igreja.Igreja;
import aan.edificaapi.igreja.IgrejaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
