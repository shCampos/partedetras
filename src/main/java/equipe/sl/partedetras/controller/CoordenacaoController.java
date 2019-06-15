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
import equipe.sl.partedetras.model.Coordenacao;
import equipe.sl.partedetras.repository.CoordenacaoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CoordenacaoController {
    @Autowired
    private CoordenacaoRepository coordenacaoRepository;

    @GetMapping("/coordenacao")
    public List<Coordenacao> getAllCoordenacao() {
        return coordenacaoRepository.findAll();
    }

    /*@GetMapping("/requerente/{id}")
    public ResponseEntity<Requerente> getRequerenteById(@PathVariable(value = "id") Long requerenteId)
        throws ResourceNotFoundException {
            Requerente requerente = requerenteRepository.findById(requerenteId)
          .orElseThrow(() -> new ResourceNotFoundException("requerente not found for this id :: " + requerenteId));
        return ResponseEntity.ok().body(requerente);
    }*/
    
    @GetMapping("/coordenacao/{setor}")
    public ResponseEntity<Coordenacao> getCoordenacaoBySetor(@PathVariable(value = "setor") String coordSetor) throws ResourceNotFoundException {
        Coordenacao coordenacao = coordenacaoRepository.findBySetor(coordSetor);
        System.out.println("SETOR ACHADO"+coordSetor+coordenacao);
        return ResponseEntity.ok().body(coordenacao);
    }

    @PostMapping("/coordenacao")
    public Coordenacao createCoordenacao(@Valid @RequestBody Coordenacao coordenacao) {
        System.out.println("CHEGOU REQUERENTE"+coordenacao);
        return coordenacaoRepository.save((Coordenacao) coordenacao);
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