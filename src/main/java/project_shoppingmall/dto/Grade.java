package project_shoppingmall.dto;

public class Grade {
	private String grade;
	private int totalp;
	
	public Grade() {
		
	}

	
	public Grade(String grade) {
		this.grade = grade;
	}


	public Grade(String grade, int totalp) {
		this.grade = grade;
		this.totalp = totalp;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getTotalp() {
		return totalp;
	}


	public void setTotalp(int totalp) {
		this.totalp = totalp;
	}


	@Override
	public String toString() {
		return "등급 = " + grade + ", 누적금액 = " + totalp;
	}
	
	
}
