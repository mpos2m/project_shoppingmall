package project_shoppingmall.dto;

public class User_Info {
	private String user_no;
	private String user_id;
	private String user_pass;
	private String user_name;
	private String user_birth;
	private String user_phone;
	private String user_address;
	private String user_sex;
	private String upass_find;
	private String upass_answer;
	private int user_totalp;
	private Grade grade;
	
	public User_Info() {
		
	}
	
	
	public User_Info(String user_no, String user_name) {
		this.user_no = user_no;
		this.user_name = user_name;
	}


	public User_Info(String user_id) {
		this.user_id = user_id;
	}

	public User_Info(String user_no, String user_id, String user_pass, String user_name, String user_birth,
			String user_phone, String user_address, String user_sex, String upass_find, String upass_answer,
			int user_totalp, Grade grade) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_name = user_name;
		this.user_birth = user_birth;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_sex = user_sex;
		this.upass_find = upass_find;
		this.upass_answer = upass_answer;
		this.user_totalp = user_totalp;
		this.grade = grade;
	}


	public String getUser_no() {
		return user_no;
	}


	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pass() {
		return user_pass;
	}


	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_birth() {
		return user_birth;
	}


	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	public String getUser_address() {
		return user_address;
	}


	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	public String getUser_sex() {
		return user_sex;
	}


	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}


	public String getUpass_find() {
		return upass_find;
	}


	public void setUpass_find(String upass_find) {
		this.upass_find = upass_find;
	}


	public String getUpass_answer() {
		return upass_answer;
	}


	public void setUpass_answer(String upass_answer) {
		this.upass_answer = upass_answer;
	}


	public int getUser_totalp() {
		return user_totalp;
	}


	public void setUser_totalp(int user_totalp) {
		this.user_totalp = user_totalp;
	}


	public Grade getGrade() {
		return grade;
	}


	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "회원 번호 = " + user_no + ", 회원 아이디 = " + user_id + ", 회원 비밀번호 = " + user_pass + ", 회원 이름 = "
				+ user_name + ", 생일 = " + user_birth + ", 휴대전화 = " + user_phone + ", 주소 = "
				+ user_address + ", 성별 = " + user_sex + ", 비밀번호 찾기 질문 = " + upass_find + ", 비밀번호 찾기 답변 = "
				+ upass_answer + ", 누적금액 = " + user_totalp + ", 등급 = " + grade;
	}
	
	
	
	
}
