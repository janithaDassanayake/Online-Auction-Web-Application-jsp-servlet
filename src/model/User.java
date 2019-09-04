/**
 * 
 */
package model;

/**
 * @author thilini
 *
 */
public class User {

	private String sl_no;
	private String user_name ;
	private String email ;
	private String mobile;
	private String address ;
	private String memberType ;
	private String gender;
	
	
	/*
	public User(String sl_no, String user_name, String email, String mobile, String address, String memberType,
			String gender) {
		super();
		this.sl_no = sl_no;
		this.user_name = user_name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.memberType = memberType;
		this.gender = gender;
		
		
	}
	*/
	
	public String getSl_no() {
		return sl_no;
	}
	public void setSl_no(String sl_no) {
		this.sl_no = sl_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return "User [sl_no=" + sl_no + ", user_name=" + user_name + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", memberType=" + memberType + ", gender=" + gender + "]";
	}
	
	
	
	
	
}
