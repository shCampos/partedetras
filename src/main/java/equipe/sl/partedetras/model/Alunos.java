package equipe.sl.partedetras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "alunos")
public class Alunos{
    private long id;
    private String campus;
    private String polo;
    private String coordenacao;
    private String curso;
    private String nome_estudante;
    private String situacao;
    private String ultima_modificacao;
    private String data_de_ingresso;
    private String periodo_entrada;
    private String matricula;
    private String ra;
    private String turno;
    private String periodo_atual;

    public Alunos(){}

    public Alunos(String campus, String polo, String coordenacao, String curso, String nome_estudante,
                    String situacao, String ultima_modificacao, String data_de_ingresso, String matricula,
                    String ra, String turno, String periodo_atual){
        this.campus = campus;
        this.polo = polo;
        this.coordenacao = coordenacao;
        this.curso = curso;
        this.nome_estudante = nome_estudante;
        this.situacao = situacao;
        this.ultima_modificacao = ultima_modificacao;
        this.data_de_ingresso = data_de_ingresso;
        this.matricula = matricula;
        this.ra = ra;
        this.turno = turno;
        this.periodo_atual = periodo_atual;
    }  

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "campus", nullable = false)
    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Column(name = "polo", nullable = true)
    public String getPolo() {
        return polo;
    }
    public void setPolo(String polo) {
        this.polo = polo;
    }
    
    @Column(name = "coordenacao", nullable = false)
    public String getCoordenacao() {
        return coordenacao;
    }
    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }

    @Column(name = "curso", nullable = false)
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Column(name = "nome_estudante", nullable = false)
    public String getNome_estudante(){
        return nome_estudante;
    }
    public void setNome_estudante(String nome_estudante){
        this.nome_estudante = nome_estudante;
    }

    @Column(name = "situacao", nullable = false)
    public String getSituacao(){
        return situacao;
    }
    public void setSituacao(String situacao){
        this.situacao = situacao;
    }

    @Column(name = "ultima_modificacao", nullable = true)
    public String getUltima_modificacao(){
        return ultima_modificacao;
    }
    public void setUltima_modificacao(String ultima_modificacao){
        this.ultima_modificacao = ultima_modificacao;
    }

    @Column(name = "data_de_ingresso", nullable = false)
    public String getData_de_ingresso(){
        return data_de_ingresso;
    }
    public void setData_de_ingresso(String data_de_ingresso){
        this.data_de_ingresso = data_de_ingresso;
    }

    @Column(name = "periodo_entrada", nullable = false)
    public String getPeriodo_entrada(){
        return periodo_entrada;
    }
    public void setPeriodo_entrada(String periodo_entrada){
        this.periodo_entrada = periodo_entrada;
    }

    @Column(name = "matricula", nullable = false)
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    @Column(name = "ra", nullable = false)
    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }

    @Column(name = "turno", nullable = false)
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Column(name = "periodo_atual", nullable = false)
    public String getPeriodo_atual() {
        return periodo_atual;
    }
    public void setPeriodo_atual(String periodo_atual) {
        this.periodo_atual = periodo_atual;
    }
    
    @Override
    public String toString() {
        return "Requerente [id=" + id + ", campus=" + campus + ", polo=" + polo + ", coordenacao=" + coordenacao +
            ", curso=" + curso + ", nome_estudante=" + nome_estudante + ", situacao=" + situacao + 
            ", ultima_modificacao=" + ultima_modificacao + ", data_de_ingresso=" + data_de_ingresso + 
            ", periodo_entrada=" + periodo_entrada + ", matricula=" + matricula + 
            ", ra=" + ra + ", turno=" + turno + ", periodo_atual=" + periodo_atual + "]";
    }
}