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
    private boolean accepted;
    private boolean rejected;

    public Applicant(){
        this.accepted = false;
        this.rejected = false;
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", work=" + work +
                ", users=" + users +
                ", accepted=" + accepted +
                ", rejected=" + rejected +
                '}';
    }
}
