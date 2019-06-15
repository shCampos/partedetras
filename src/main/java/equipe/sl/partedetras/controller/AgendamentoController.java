package equipe.sl.partedetras.controller;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import equipe.sl.partedetras.exception.ResourceNotFoundException;
import equipe.sl.partedetras.model.Agendamento;
import equipe.sl.partedetras.repository.AgendamentoRepository;;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AgendamentoController {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping("/agendamento")
    public List<Agendamento> getAllAgendamento() {
        return agendamentoRepository.findAll();
    }

    /*@GetMapping("/requerente/{id}")
    public ResponseEntity<Requerente> getRequerenteById(@PathVariable(value = "id") Long requerenteId)
        throws ResourceNotFoundException {
            Requerente requerente = requerenteRepository.findById(requerenteId)
          .orElseThrow(() -> new ResourceNotFoundException("requerente not found for this id :: " + requerenteId));
        return ResponseEntity.ok().body(requerente);
    }*/

    @GetMapping("agendamento/req/{id}")
    public ResponseEntity<Agendamento> getAgendamentoByReqId(@PathVariable(value = "id") int reqId){
        Agendamento agendamento = agendamentoRepository.findByReqId(reqId);
        return ResponseEntity.ok().body(agendamento);
    }

    @PostMapping("/agendamento")
    public Agendamento createCoordenacao(@Valid @RequestBody Agendamento agendamento) {
        System.out.println("CHEGOU AGENDAMENTO"+agendamento);
        return agendamentoRepository.save((Agendamento) agendamento);
    }
}