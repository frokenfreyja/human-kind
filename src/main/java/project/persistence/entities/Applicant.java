package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long work;
    private Long users;

    public Applicant(){

    }

    public Long getId() {
        return id;
    }

    public Long getWork() {
        return work;
    }

    public void setWork(Long work) {
        this.work = work;
    }

    public Long getUser() {
        return users;
    }

    public void setUser(Long users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", workID=" + work +
                ", userID=" + users +
                '}';
    }
}
