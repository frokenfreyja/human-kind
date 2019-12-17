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

    public Accepted() {}

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
}
