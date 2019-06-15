package equipe.sl.partedetras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "professor")

public class Professor{
    @Id
    private long id;
    private String nome;
    private String email;
    private String senha;

    public Professor(){}

    public Professor(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
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

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "senha", nullable = false)
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
    }
}