package equipe.sl.partedetras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agendamento")

public class Agendamento{
    @Id
    private long id;
    private int id_prof;
    private int id_req;
    private int id_estudante;
    private String data;
    
    public Agendamento(){}

    public Agendamento(int id_prof, int id_req, String data){
        this.id_prof = id_prof;
        this.id_req = id_req;
        this.data = data;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "id_prof", nullable = false)
    public int getId_prof() {
        return id_prof;
    }
    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    @Column(name = "id_req", nullable = false)
    public int getId_req() {
        return id_req;
    }
    public void setId_req(int id_req) {
        this.id_req = id_req;
    }

    @Column(name = "id_estudante", nullable = false)
    public int getId_estudante(){
        return id_estudante;
    }
    public void setId_estudante(int id_estudante){
        this.id_estudante = id_estudante;
    }

    @Column(name = "data", nullable = false)
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Coordenacao [id=" + id + ", id_prof=" + id_prof + ", id_req=" + id_req + ", id_estudante=" + id_estudante + ", data=" + data + "]";
    }
}