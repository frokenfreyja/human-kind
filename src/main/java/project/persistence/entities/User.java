package project.persistence.entities;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String gender;
    private String password;
    @Transient
    private String confirmPassword;
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Transient
    private MultipartFile image;
    private String imageName;

    @Column(columnDefinition="text")
    private String bio;
    private Boolean orgi;

    private boolean isEnabled;

    public User(){

    }

    public User(String name, String email, String gender, String password, String phone, Date birthDate, String bio, Boolean orgi,
                MultipartFile image) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.birthDate = birthDate;
        this.bio = bio;
        this.orgi = orgi;
        this.image = image;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Boolean getOrgi() {
        return orgi;
    }

    public void setOrgi(Boolean orgi) {
        this.orgi = orgi;
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
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
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", image=" + image +
                ", imageName='" + imageName + '\'' +
                ", bio='" + bio + '\'' +
                ", orgi=" + orgi +
                '}';
    }
}
