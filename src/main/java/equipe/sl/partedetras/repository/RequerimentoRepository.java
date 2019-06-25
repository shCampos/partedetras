package equipe.sl.partedetras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import equipe.sl.partedetras.model.Requerimento;
import equipe.sl.partedetras.model.Alunos;
import equipe.sl.partedetras.model.Professor;

@Repository
public interface RequerimentoRepository extends JpaRepository<Requerimento, Long>{

    @Query("SELECT r, a, p FROM Requerimento r INNER JOIN Alunos a ON r.id_estudante = a.id AND a.id =:id INNER JOIN Professor p ON r.id_professor = p.id")
    //@Query("SELECT r FROM Requerimento r WHERE id_estudante =:id_estudante")
    public List<Object> findByEstId(@Param("id") long id_estudante);

    @Query("SELECT r FROM Requerimento r WHERE hash = :hash")
    public Requerimento findByHash(@Param("hash") String hash);
    
    @Query("SELECT r FROM Requerimento r WHERE status =:status")
    public List<Requerimento> findByStatus(@Param("status") String status);

    @Query("SELECT r, a, p FROM Requerimento r INNER JOIN Alunos a ON r.id_estudante = a.id INNER JOIN Professor p ON r.id_professor = p.id")
    public List<Object> findTudo();

    @Query("SELECT r, a, p FROM Requerimento r INNER JOIN Alunos a ON r.id_estudante = a.id AND a.coordenacao=:coordenacao INNER JOIN Professor p ON r.id_professor = p.id")
    public List<Object> findTudoCoord(@Param("coordenacao") String coordenacao);

    @Query("SELECT r, a, p FROM Requerimento r INNER JOIN Alunos a ON r.id_estudante = a.id AND (r.status = 'Deferido' OR r.status = 'Agendado') INNER JOIN Professor p ON r.id_professor = p.id AND p.id = :id")
    public List<Object> findTudoProf(@Param("id") long id_professor);
}