package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ssk")
public class Ssk implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "ssks",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Unit> units = new HashSet<Unit>();

    private String name;
    //构造函数
    public Ssk() {
    }
    public Ssk(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
