package equipe.sl.partedetras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coordenacao")

public class Coordenacao{
    @Id
    private long id;
    private String setor;
    private String senha;
    
    public Coordenacao(){}

    public Coordenacao(String setor, String senha){
        this.setor = setor;
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "setor", nullable = false)
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Coordenacao [id=" + id + ", setor=" + setor + ", senha=" + senha +"]";
    }
}