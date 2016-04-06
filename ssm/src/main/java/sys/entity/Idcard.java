package sys.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Idcard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "idcard", catalog = "db_ssh")
public class Idcard implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String idcardname;

	// Constructors

	/** default constructor */
	public Idcard() {
	}

	/** minimal constructor */
	public Idcard(Integer id, User user) {
		this.id = id;
		this.user = user;
	}

	/** full constructor */
	public Idcard(Integer id, User user, String idcardname) {
		this.id = id;
		this.user = user;
		this.idcardname = idcardname;
	}

	// Property accessors
	@Id
	@GenericGenerator(name="foreignKey", strategy="foreign", parameters=@Parameter(name="property", value="user"))
	@GeneratedValue(generator="foreignKey", strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Fetch(FetchMode.SELECT)
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="idcard")
	@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "idcardname", length = 30)
	public String getIdcardname() {
		return this.idcardname;
	}

	public void setIdcardname(String idcardname) {
		this.idcardname = idcardname;
	}

//	@Override
//	public String toString() {
//		return "Idcard [id=" + id + ", idcardname=" + idcardname + "]";
//	}

	@Override
	public String toString() {
		return "Idcard [id=" + id + ", user=" + user + ", idcardname="
				+ idcardname + "]";
	}

	
}