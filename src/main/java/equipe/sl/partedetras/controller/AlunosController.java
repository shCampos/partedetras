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
import equipe.sl.partedetras.model.Alunos;
import equipe.sl.partedetras.repository.AlunosRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AlunosController {
    @Autowired
    private AlunosRepository alunosRepository;

    @GetMapping("/alunos")
    public List<Alunos> getAllAlunos() {
        return alunosRepository.findAll();
    }

    @GetMapping("/alunos/ra/{ra}")
    public ResponseEntity<Alunos> getAlunosByRa(@PathVariable(value = "ra") String alunoRa) {
        Alunos aluno = alunosRepository.findByRa(alunoRa);
        System.out.println("RA ACHADO"+alunoRa+aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("/alunos/id/{id}")
    public ResponseEntity<Alunos> getAlunosById(@PathVariable(value = "id") Long alunoId) throws ResourceNotFoundException {
        Alunos aluno = alunosRepository.findById(alunoId)
        .orElseThrow(() -> new ResourceNotFoundException("aluno not found for this id :: " + alunoId));
        System.out.println("ID ACHADO"+alunoId+aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping("/alunos")
    public Alunos createAlunos(@Valid @RequestBody Alunos aluno) {
        System.out.println("CHEGOU ALUNO"+aluno);
        return alunosRepository.save((Alunos) aluno);
    }

    /*@PutMapping("/requerente/{id}")
    public ResponseEntity<Requerente> updateRequerente(@PathVariable(value = "id") Long requerenteId,
         @Valid @RequestBody Requerente requerenteDetails) throws ResourceNotFoundException {
        Requerente requerente = requerenteRepository.findById(requerenteId)
        .orElseThrow(() -> new ResourceNotFoundException("requerente not found for this id :: " + requerenteId));

        requerente.setNome(requerenteDetails.getCpf());
        final Requerente updatedRequerente = requerenteRepository.save(requerente);
        return ResponseEntity.ok(updatedRequerente);
    }

    @DeleteMapping("/requerente/{id}")
    public Map<String, Boolean> deleteRequerente(@PathVariable(value = "id") Long requerenteId)
         throws ResourceNotFoundException {
        Requerente requerente = requerenteRepository.findById(requerenteId)
       .orElseThrow(() -> new ResourceNotFoundException("requerente not found for this id :: " + requerenteId));

       requerenteRepository.delete(requerente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
}