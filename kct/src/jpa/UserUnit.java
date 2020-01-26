package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userUnit")
public class UserUnit implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Tag tag;

    @ManyToOne
    private Unit unit;

    @ManyToOne
 
    private User user;

	public UserUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserUnit(Unit unit, User user) {
		super();
		this.unit = unit;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
