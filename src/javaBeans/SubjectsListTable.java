package javaBeans;

public class SubjectsListTable {
	private String subjects_cd;
	private String subjects_name;
	private String subjects_short_name;
	private String year;

	public SubjectsListTable(String subjects_cd, String subjects_name) {
		super();
		this.subjects_cd = subjects_cd;
		this.subjects_name = subjects_name;
	}

	public String getSubjects_cd() {
		return subjects_cd;
	}
	public void setSubjects_cd(String subjects_cd) {
		this.subjects_cd = subjects_cd;
	}
	public String getSubjects_name() {
		return subjects_name;
	}
	public void setSubjects_name(String subjects_name) {
		this.subjects_name = subjects_name;
	}
	public String getSubjects_short_name() {
		return subjects_short_name;
	}
	public void setSubjects_short_name(String subjects_short_name) {
		this.subjects_short_name = subjects_short_name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

}
