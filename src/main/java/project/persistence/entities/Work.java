package project.persistence.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String duration;

    @Column(length=2048)
    private String description;
    private Long owner;
    private String organization;
    private int payout;
    private String interest;
    private Integer zipcode;
    @Transient
    private MultipartFile image;
    private String imageName;
    private String generalLoc;

    // Þarf að finna leið til að búa til list í db
   // private List<User> applicants;
  //  private List<User> accepted;
  //  private List<User> rejected;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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

    public String getGeneralLoc(Integer zip) {
        String generalLocation = "";
        List<Integer> hofudborg = Arrays.asList(101, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 116,
                170, 200, 201, 203, 210, 225, 220, 221, 270, 271, 276);
        List<Integer> vesturland = Arrays.asList(300, 301, 310, 311, 320, 340, 345, 350, 355, 356, 360, 370, 371,
                380);
        List<Integer> vestfirdir = Arrays.asList(400, 401, 410, 415, 420, 425, 430, 450, 451, 460, 465, 470, 471,
                510, 520, 524);
        List<Integer> nordurland = Arrays.asList(500, 530, 531, 540, 541, 545, 550, 560, 565, 566, 570, 580, 600,
                601, 603, 610, 611, 620, 621, 625, 630, 640, 641, 645, 650, 660, 670, 671, 675, 680, 681);
        List<Integer> austurland = Arrays.asList(685, 690, 700, 701, 710, 715, 720, 730, 735, 740, 750, 755, 760,
                765, 780, 781, 785);
        List<Integer> sudurland = Arrays.asList(800, 801, 810, 815, 816, 820, 825, 840, 845, 850, 851, 860, 861,
                870, 871, 880, 900);
        List<Integer> sudurnes = Arrays.asList(190, 230, 233, 235, 240, 245, 250, 260);

        if(hofudborg.contains(zip)) {
            generalLocation = "Höfuðborgarsvæðið";
        } else if(vesturland.contains(zip)) {
            generalLocation = "Vesturland";
        } else if(vestfirdir.contains(zip)) {
            generalLocation = "Vestfirðir";
        } else if(nordurland.contains(zip)) {
            generalLocation = "Norðurland";
        } else if(austurland.contains(zip)) {
            generalLocation = "Austurland";
        } else if(sudurland.contains(zip)) {
            generalLocation = "Suðurland";
        } else if(sudurnes.contains(zip)) {
            generalLocation = "Suðurnes";
        }
        return generalLocation;
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
