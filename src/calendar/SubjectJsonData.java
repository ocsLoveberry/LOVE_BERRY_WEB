package calendar;

public class SubjectJsonData {

	private String subject_cd;
	private String start;
	private String end;
	private int count;
	private String room_cd1;
	private String room_cd2;
	private String room_cd3;


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

	public SubjectJsonData(String subject_cd, String start, String end, int count, String room_cd1, String room_cd2,String room_cd3) {
		this.subject_cd = subject_cd;
		this.start = start;
		this.end = end;
		this.count = count;
		this.room_cd1 = room_cd1;
		this.room_cd2 = room_cd2;
		this.room_cd3 = room_cd3;
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

	public String getRoom_cd1() {
		return room_cd1;
	}

	public void setRoom_cd1(String room_cd1) {
		this.room_cd1 = room_cd1;
	}

	public String getRoom_cd2() {
		return room_cd2;
	}

	public void setRoom_cd2(String room_cd2) {
		this.room_cd2 = room_cd2;
	}

	public String getRoom_cd3() {
		return room_cd3;
	}

	public void setRoom_cd3(String room_cd3) {
		this.room_cd3 = room_cd3;
	}
}
