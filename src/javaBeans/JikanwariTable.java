package javaBeans;

public class JikanwariTable {

	private String class_cd;
	private String start_date;
	private String start_time_cd;
	private String tokutei_cd;



	public JikanwariTable(String class_cd, String start_date, String start_time_cd, String tokutei_cd) {
		super();
		this.class_cd = class_cd;
		this.start_date = start_date;
		this.start_time_cd = start_time_cd;
		this.tokutei_cd = tokutei_cd;
	}

	public String getClass_cd() {
		return class_cd;
	}
	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getStart_time_cd() {
		return start_time_cd;
	}
	public void setStart_time_cd(String start_time_cd) {
		this.start_time_cd = start_time_cd;
	}
	public String getTokutei_cd() {
		return tokutei_cd;
	}
	public void setTokutei_cd(String tokutei_cd) {
		this.tokutei_cd = tokutei_cd;
	}



}
