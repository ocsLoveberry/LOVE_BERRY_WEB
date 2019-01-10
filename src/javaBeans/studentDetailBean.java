package javaBeans;

public class studentDetailBean {
	private String seki_no;
	private String name;
	private String department;
	private String major;
	private String studentClass;
	private String admissionYear;
	private String message;
	private String[] subject1;
	private String[] subject2;
	private String[] subject3;
	private String studentFelicaID1;
	private String studentFelicaID2;
//	private String studentFelicaEntryDate;

	public studentDetailBean(String seki_no, String name, String department, String major, String studentClass,
			String admissionYear, String message, String studentFelicaID1, String studentFelicaID2) {
		super();
		try {
		this.seki_no = seki_no;
		this.name = name;
		if (department.equals("R")) {
			department = "大学併修科";
		}
		this.department = department;
		if (major.equals("r_system")) {
			major = "システム情報学科";
		}
		this.major = major;
		this.studentClass = studentClass.substring(0, 4);
		this.admissionYear = admissionYear;
		this.message = message;
		this.studentFelicaID1 = studentFelicaID1;
		this.setStudentFelicaID2(studentFelicaID2);
//		this.studentFelicaEntryDate = studentFelicaEntryDate;
		}catch(NullPointerException e) {
//		gakka,senko,classは教員nullなのでここは何もしない
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public String getSeki_no() {
		return seki_no;
	}

	public void setSeki_no(String seki_no) {
		this.seki_no = seki_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionYear(String admissionYear) {
		this.admissionYear = admissionYear;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getSubject1() {
		return subject1;
	}

	public void setSubject1(String[] subject1) {
		this.subject1 = subject1;
	}

	public String[] getSubject2() {
		return subject2;
	}

	public void setSubject2(String[] subject2) {
		this.subject2 = subject2;
	}

	public String[] getSubject3() {
		return subject3;
	}

	public void setSubject3(String[] subject3) {
		this.subject3 = subject3;
	}

	public String getStudentFelicaID1() {
		return studentFelicaID1;
	}

	public void setStudentFelicaID1(String studentFelicaID1) {
		this.studentFelicaID1 = studentFelicaID1;
	}

	public String getStudentFelicaID2() {
		return studentFelicaID2;
	}

	public void setStudentFelicaID2(String studentFelicaID2) {
		this.studentFelicaID2 = studentFelicaID2;
	}

//	public String getStudentFelicaEntryDate() {
//		return studentFelicaEntryDate;
//	}
//
//	public void setStudentFelicaEntryDate(String studentFelicaEntryDate) {
//		this.studentFelicaEntryDate = studentFelicaEntryDate;
//	}
}