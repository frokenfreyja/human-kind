package project.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phone;
    private String bio;
    private int points;
    private Boolean isOrgi;
    // Þarf að finna leið til að búa til list í db
   // private List<Course> courses;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Boolean getOrgi() {
        return isOrgi;
    }

    public void setOrgi(Boolean orgi) {
        isOrgi = orgi;
    }

  /*  public List<Course> getCourses() {
        return courses;
    }
*/
}
