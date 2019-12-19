package project.persistence.entities;


import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cname;

    public Course(){

    }

    public Long getId() {
        return id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                '}';
    }
}
