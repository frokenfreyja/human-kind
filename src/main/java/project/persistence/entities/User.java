package project.persistence.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
    @Transient
    private MultipartFile image;
    private String imageName;
    private String bio;
    private int points;
    private Boolean Orgi;
    // Þarf að finna leið til að búa til list í db
   // private List<Course> courses;

    public User(){

    }

    public User(String name, String email, String password, String phone, String bio, Boolean isOrgi, MultipartFile image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.bio = bio;
        this.Orgi = Orgi;
        this.image = image;
        this.imageName = imageName;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Orgi;
    }

    public void setOrgi(Boolean Orgi) {
        this.Orgi = Orgi;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /*  public List<Course> getCourses() {
        return courses;
    }
*/


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", image=" + image +
                ", imageName='" + imageName + '\'' +
                ", bio='" + bio + '\'' +
                ", points=" + points +
                ", Orgi=" + Orgi +
                '}';
    }
}
