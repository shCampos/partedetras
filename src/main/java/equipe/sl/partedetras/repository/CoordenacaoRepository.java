package equipe.sl.partedetras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import equipe.sl.partedetras.model.Coordenacao;

@Repository
public interface CoordenacaoRepository extends JpaRepository<Coordenacao, Long>{

    @Query("SELECT c FROM Coordenacao c WHERE setor = :setor")
    public Coordenacao findBySetor(@Param("setor") String setor);
}