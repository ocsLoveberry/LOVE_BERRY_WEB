package calendar;

public class SubjectJsonData {

	String subject_cd;
	String start;
	String end;
	int count;

	public SubjectJsonData(int count, String subject_cd) {
		super();
		this.count = count;
		this.subject_cd = subject_cd;
	}

	public SubjectJsonData(String subject_cd, String start, String end, int count) {
		super();
		this.subject_cd = subject_cd;
		this.start = start;
		this.end = end;
		this.count = count;
	}

	public String getSubject_cd() {
		return subject_cd;
	}
	public void setSubject_cd(String subject_cd) {
		this.subject_cd = subject_cd;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}



}
