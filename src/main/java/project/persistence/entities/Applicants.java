package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "applicants")
public class Applicants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long workID;
    private Long userID;

    public Applicants(){

    }

    public Long getWorkID() {
        return workID;
    }

    public void setWorkID(Long workID) {
        this.workID = workID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
