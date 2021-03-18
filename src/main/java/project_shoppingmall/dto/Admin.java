package project_shoppingmall.dto;

public class Admin {
	private String ad_id;
	private String ad_pass;
	private String ad_name;
	
	public Admin() {
		
	}
	
	public Admin(String ad_id) {
		this.ad_id = ad_id;
	}

	public Admin(String ad_id, String ad_pass, String ad_name) {
		this.ad_id = ad_id;
		this.ad_pass = ad_pass;
		this.ad_name = ad_name;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_pass() {
		return ad_pass;
	}

	public void setAd_pass(String ad_pass) {
		this.ad_pass = ad_pass;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	@Override
	public String toString() {
		return "관리자 아이디 = " + ad_id + ", 관리자 비밀번호 = " + ad_pass + ", 관리자 이름 = " + ad_name;
	}
	
}
