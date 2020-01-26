package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class Status implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "status")
    private List<Unit> units = new ArrayList<Unit>();

    private String name;
    


    public int getId() {
        return id;
    }



	public void setId(int id) {
        this.id = id;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //构造函数
    public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

}
