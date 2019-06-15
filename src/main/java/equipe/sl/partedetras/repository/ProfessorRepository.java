package equipe.sl.partedetras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import equipe.sl.partedetras.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    @Query("SELECT p FROM Professor p WHERE email = :email")
    public Professor findByEmail(@Param("email") String email);
}