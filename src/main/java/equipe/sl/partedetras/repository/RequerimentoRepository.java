package equipe.sl.partedetras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import equipe.sl.partedetras.model.Requerimento;

@Repository
public interface RequerimentoRepository extends JpaRepository<Requerimento, Long>{

    @Query("SELECT r FROM Requerimento r WHERE id_estudante =:id_estudante")
    public List<Requerimento> findByEstId(@Param("id_estudante") Integer id_estudante);

    @Query("SELECT r FROM Requerimento r WHERE hash = :hash")
    public Requerimento findByHash(@Param("hash") String hash);
    
    @Query("SELECT r FROM Requerimento r WHERE status =:status")
    public List<Requerimento> findByStatus(@Param("status") String status);
}