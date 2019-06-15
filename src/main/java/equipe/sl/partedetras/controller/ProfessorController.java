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
import equipe.sl.partedetras.model.Professor;
import equipe.sl.partedetras.repository.ProfessorRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("")
    public String Hello(){
        return "ta funcionando";
    }
    @GetMapping("/professor")
    public List<Professor> getAllProfessor() {
        return professorRepository.findAll();
    }

    /*@GetMapping("/requerente/{id}")
    public ResponseEntity<Requerente> getRequerenteById(@PathVariable(value = "id") Long requerenteId)
        throws ResourceNotFoundException {
            Requerente requerente = requerenteRepository.findById(requerenteId)
          .orElseThrow(() -> new ResourceNotFoundException("requerente not found for this id :: " + requerenteId));
        return ResponseEntity.ok().body(requerente);
    }*/
    
    @GetMapping("/professor/email/{email}")
    public ResponseEntity<Professor> getProfessorByEmail(@PathVariable(value = "email") String professorEmail) throws ResourceNotFoundException {
        Professor professor= professorRepository.findByEmail(professorEmail);
        System.out.println("CPF ACHADO"+professorEmail+professor);
        return ResponseEntity.ok().body(professor);
    }

    @GetMapping("/professor/id/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable(value = "id") Long professorId) throws ResourceNotFoundException {
        Professor professor = professorRepository.findById(professorId)
        .orElseThrow(() -> new ResourceNotFoundException("requerente not found for this id :: " + professorId));
        System.out.println("ID ACHADO"+professorId+professor);
        return ResponseEntity.ok().body(professor);
    }

    @PostMapping("/professor")
    public Professor createProfessor(@Valid @RequestBody Professor professor) {
        System.out.println("CHEGOU PROFESSOR"+professor);
        return professorRepository.save((Professor) professor);
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