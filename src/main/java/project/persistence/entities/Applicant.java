package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long workid;
    private Long userid;

    public Applicant(){

    }

    public Long getId() {
        return id;
    }

    public Long getWork() {
        return workid;
    }

    public void setWork(Long workid) {
        this.workid = workid;
    }

    public Long getUser() {
        return userid;
    }

    public void setUser(Long userid) {
        this.userid = userid;
    }
}
