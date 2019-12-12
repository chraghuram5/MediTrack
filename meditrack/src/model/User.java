package model;

public class User {
	private int userId;
	private String fname;
	private String lname;
	private String email;
	private String gender;
	private String uname;
	private String mobile;
	private String password;
	private String role;
	private int asId;
	
	public User(int userId, String fname, String lname, String email, String gender, String uname, String mobile,
			String password, String role) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.uname = uname;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		
	}
	
	
	public User(int userId, String fname, String lname, String email, String gender, String uname, String mobile,
			String password, String role, int asId) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.uname = uname;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.asId = asId;
	}


	public User(String fname, String lname, String email, String gender, String uname, String mobile, String password,
			String role, int asId) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.uname = uname;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.asId = asId;
	}


	public User(String fname, String lname, String email, String gender, String uname, String mobile, String password,
			String role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.uname = uname;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}


	public int getAssId() {
		return asId;
	}


	public void setAssId(int asId) {
		this.asId = asId;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}

