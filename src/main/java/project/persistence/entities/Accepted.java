package project.persistence.entities;

import javax.persistence.*;


@Entity
@Table(name = "accepted")
public class Accepted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long work;
    private Long users;
    private boolean accept;

    public Accepted() {
        this.accept = false;
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

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
        this.users = users;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "Accepted{" +
                "id=" + id +
                ", work=" + work +
                ", users=" + users +
                ", accept=" + accept +
                '}';
    }
}
