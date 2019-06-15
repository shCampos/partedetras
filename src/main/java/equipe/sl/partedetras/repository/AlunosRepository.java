package equipe.sl.partedetras.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import equipe.sl.partedetras.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long>{

    @Query("SELECT a FROM Alunos a WHERE ra = :ra")
    public Alunos findByRa(@Param("ra") String ra);
}