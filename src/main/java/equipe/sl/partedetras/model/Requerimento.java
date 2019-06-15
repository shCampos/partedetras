package equipe.sl.partedetras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requerimento")

public class Requerimento{
    private long id;
    private int id_estudante;
    private String materia;
    private int id_professor;
    private String justificativa;
    private String anexo;
    private String status;
    private String hash;

    public Requerimento(){ }

    public Requerimento(int id_estudante, String materia, int id_professor, String justificativa, String anexo, String status, String hash){
        this.id_estudante = id_estudante;
        this.materia = materia;
        this.id_professor = id_professor;
        this.justificativa = justificativa;
        this.anexo = anexo;
        this.status = status;
        this.hash = hash;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "id_estudante", nullable = false)
    public int getId_estudante() {
        return id_estudante;
    }
    public void setId_estudante(int id_estudante) {
        this.id_estudante = id_estudante;
    }

    @Column(name = "materia", nullable = false)
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Column(name = "id_professor", nullable = false)
    public int getId_professor() {
        return id_professor;
    }
    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    @Column(name = "justificativa", nullable = false)
    public String getJustificativa() {
        return justificativa;
    }
    public void setjustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Column(name = "anexo", nullable = true)
    public String getAnexo() {
        return anexo;
    }
    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "hash", nullable = false)
    public String getHash(){
        return hash;
    }
    public void setHash(String hash){
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Requerimento [id=" + id + ", id_estudante=" + id_estudante + ", materia=" + materia + ", id_professor=" + id_professor + 
        ", justificativa=" + justificativa + ", anexo=" + anexo + ", status=" + status + ",hash=" + hash + "]";
    }
}
