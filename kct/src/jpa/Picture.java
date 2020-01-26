package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "picture")
public class Picture implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "picture")
    private Unit unit;

    private String p_bar;
    private String p_card;
    private String p_perfect;
    private String p_damaged;
    //构造函数
    public Picture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getP_bar() {
        return p_bar;
    }

    public void setP_bar(String p_bar) {
        this.p_bar = p_bar;
    }

    public String getP_card() {
        return p_card;
    }

    public void setP_card(String p_card) {
        this.p_card = p_card;
    }

    public String getP_perfect() {
        return p_perfect;
    }

    public void setP_perfect(String p_perfect) {
        this.p_perfect = p_perfect;
    }

    public String getP_damaged() {
        return p_damaged;
    }

    public void setP_damaged(String p_damaged) {
        this.p_damaged = p_damaged;
    }
}
