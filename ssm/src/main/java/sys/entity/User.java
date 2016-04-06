package sys.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "db_ssh")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private String username;
	private String password;
	private Idcard idcard;
	private Set<Role> roles = new HashSet<Role>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Department department, String username, String password,
			Idcard idcard, Set<Role> roles) {
		this.department = department;
		this.username = username;
		this.password = password;
		this.idcard = idcard;
		this.roles = roles;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Cascade(value={CascadeType.SAVE_UPDATE})
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "deptId")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 64)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//JPA的fetch属性对hibernae框架无效, fetch = FetchType.LAZY
	
	
	@Fetch(FetchMode.SELECT)
	@OneToOne(cascade = javax.persistence.CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Idcard getIdcard() {
		return this.idcard;
	}

	public void setIdcard(Idcard idcard) {
		this.idcard = idcard;
	}

	@Cascade(value = { CascadeType.PERSIST, CascadeType.SAVE_UPDATE })
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", catalog = "db_ssh", joinColumns = { @JoinColumn(name = "userid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "roleid", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

	

	

	

	
}