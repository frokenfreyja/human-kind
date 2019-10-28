package project.persistence.entities;

import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String date;
    private String duration;
    private String description;
    private Long owner;
    private int payout;
    private String interest;
    private Integer zipcode;
    @Transient
    private MultipartFile image;
    private String imageName;


    // Þarf að finna leið til að búa til list í db
    /*  private List<User> applicants;
    private List<User> accepted;
    private List<User> rejected;
*/

    public Work(){

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) { this.interest = interest; }

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

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

  /*  public List<User> getApplicants() {
        return applicants;
    }

    public List<User> getAccepted() {
        return accepted;
    }

    public List<User> getRejected() {
        return rejected;
    }
*/
}
