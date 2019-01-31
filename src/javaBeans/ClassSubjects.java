package javaBeans;

public class ClassSubjects {

	private String class_cd;
	private String subjects_cd;
	private String year;

	public ClassSubjects() {

	}

	public ClassSubjects(String class_cd, String subjects_cd, String year) {
		super();
		this.class_cd = class_cd;
		this.subjects_cd = subjects_cd;
		this.year = year;
	}

	public String getClass_cd() {
		return class_cd;
	}
	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}
	public String getSubjects_cd() {
		return subjects_cd;
	}
	public void setSubjects_cd(String subjects_cd) {
		this.subjects_cd = subjects_cd;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


}
