package sys.entity;

public class IdCard {
	private Integer id;
	private String idcardname;
	public Integer getId() {
		return id;
	}
	
	public IdCard(String idcardname) {
		super();
		this.idcardname = idcardname;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdCardname() {
		return idcardname;
	}
	public void setIdcardname(String idcardname) {
		this.idcardname = idcardname;
	}
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", idcardname=" + idcardname + "]";
	}
	
}
