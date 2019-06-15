package equipe.sl.partedetras.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import equipe.sl.partedetras.model.Requerimento;
import equipe.sl.partedetras.repository.RequerimentoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RequerimentoController {
    @Autowired
    private RequerimentoRepository requerimentoRepository;

    @GetMapping("/requerimento")
    public List<Requerimento> getAllRequerimento() {
        return requerimentoRepository.findAll();
    }

    @GetMapping("/requerimento/status/{status}")
    public List<Requerimento> getRequerimentoByStatus(@PathVariable(value = "status") String requerimentoStatus){
        List<Requerimento> lista = new ArrayList<>();
        lista = requerimentoRepository.findByStatus(requerimentoStatus);
        return lista;
    }
    
    @GetMapping("/requerimento/{id}")
    public ResponseEntity<Requerimento> getRequerimentoById(@PathVariable(value = "id") Long requerimentoId)
        throws ResourceNotFoundException {
            Requerimento requerimento = requerimentoRepository.findById(requerimentoId)
            .orElseThrow(() -> new ResourceNotFoundException("requerimento not found for this id :: " + requerimentoId));
            return ResponseEntity.ok().body(requerimento);
    }
    
    @GetMapping("/requerimento/hash/{hash}")
    public ResponseEntity<Requerimento> getRequerimentoByHash(@PathVariable(value = "hash") String requerimentoHash){
            Requerimento requerimento = requerimentoRepository.findByHash(requerimentoHash);
            return ResponseEntity.ok().body(requerimento);
    }

    @GetMapping("/requerimento/est/{id_est}")
    public List<Requerimento> getRequerimentoByEstId(@PathVariable(value= "id_est") Integer estudanteId){
        System.out.print("IOAHSOIAHSIO"+estudanteId);
        List<Requerimento> lista = new ArrayList<>();
        lista = requerimentoRepository.findByEstId(estudanteId);
        System.out.print("UEHUEEHUEH"+requerimentoRepository.findByEstId(estudanteId));
        return lista;
    }

    @PostMapping("/requerimento")
    public Requerimento createRequerimento(@Valid @RequestBody Requerimento requerimento) {
        System.out.println("objeto que chegou"+requerimento);
        return requerimentoRepository.save((Requerimento) requerimento);
    }

    @PutMapping("/requerimento/{id}")
    public ResponseEntity<Requerimento> updateStatus(@PathVariable(value = "id") Long requerimentoId,
         @Valid @RequestBody String requerimentoStatus) throws ResourceNotFoundException {
        Requerimento requerimento = requerimentoRepository.findById(requerimentoId)
        .orElseThrow(() -> new ResourceNotFoundException("requerimento not found for this id :: " + requerimentoId));

        requerimento.setStatus(requerimentoStatus);
        final Requerimento updatedRequerimento = requerimentoRepository.save(requerimento);

        System.out.println("SOHAIOSHAOIHS"+requerimentoId+requerimentoStatus+updatedRequerimento);
        return ResponseEntity.ok(updatedRequerimento);
    }
}