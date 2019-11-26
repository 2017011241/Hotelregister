package model;

public class Business {
	int id;
	String name;
	String password;
	String tel;
	
	public Business() {};
	public Business(int id, String name, String password, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
