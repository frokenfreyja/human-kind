package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "coursename")
public class CourseName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long course;
    private Long users;

    public CourseName(){

    }

    public Long getId() {
        return id;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        course = course;
    }

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "CourseName{" +
                "id=" + id +
                ", course=" + course +
                ", users=" + users +
                '}';
    }
}
