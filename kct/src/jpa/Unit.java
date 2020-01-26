package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "unit")
public class Unit implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "unitWithSsk",
            joinColumns = {@JoinColumn(name = "unit")},
            inverseJoinColumns = {@JoinColumn(name = "ssk")}
    )
    private Set<Ssk> ssks = new HashSet<Ssk>();

    @ManyToOne
    private Type type;

    @ManyToOne
    private ShipClass shipClass;

    @ManyToOne
    private Illustrator illustrator;

    @ManyToOne
    private VoiceActor voiceActor;

    @ManyToOne
    private Nationality nationality;

    @ManyToOne
    private Status status;
    
    @OneToOne
    private Picture picture;

    @OneToMany(mappedBy = "unit")
    private List<UserUnit> userUnits = new ArrayList<UserUnit>();
    
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Ssk> getSsks() {
		return ssks;
	}

	public void setSsks(Set<Ssk> ssks) {
		this.ssks = ssks;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ShipClass getShipClass() {
		return shipClass;
	}

	public void setShipClass(ShipClass shipClass) {
		this.shipClass = shipClass;
	}

	public Illustrator getIllustrator() {
		return illustrator;
	}

	public void setIllustrator(Illustrator illustrator) {
		this.illustrator = illustrator;
	}

	public VoiceActor getVoiceActor() {
		return voiceActor;
	}

	public void setVoiceActor(VoiceActor voiceActor) {
		this.voiceActor = voiceActor;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public List<UserUnit> getUserUnits() {
		return userUnits;
	}

	public void setUserUnits(List<UserUnit> userUnits) {
		this.userUnits = userUnits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
