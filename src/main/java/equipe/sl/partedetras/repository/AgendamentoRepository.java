package equipe.sl.partedetras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import equipe.sl.partedetras.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

    @Query("SELECT a FROM Agendamento a WHERE id_req = :id_req")
    public Agendamento findByReqId(@Param("id_req") int id_req);
}