package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "user")
    private List<UserUnit> userUnits = new ArrayList<UserUnit>();

    private String uName;
    private String uPass;

    public User() {
    }
    public User(String uName,String uPass){
        this.uName = uName;
        this.uPass = uPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserUnit> getUserUnits() {
        return userUnits;
    }

    public void setUserUnits(List<UserUnit> userUnits) {
        this.userUnits = userUnits;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }
}
