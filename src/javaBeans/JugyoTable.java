package javaBeans;

public class JugyoTable {

	private String subjects_cd;
	private String start_date;
	private String start_time_cd;
	private String start_time;
	private String end_time;
	private String card_start_time;
	private String card_end_time;
	private String room_cd1;
	private String room_cd2;
	private String room_cd3;
	private String cancel_flag;
	private String message;
	private String comment;
	private String seki_no;
	private String tokutei_cd;

	public JugyoTable(String subjects_cd, String start_date, String start_time_cd, String start_time, String end_time,
			String card_start_time, String card_end_time, String room_cd1, String room_cd2, String room_cd3,
			String cancel_flag, String message, String comment, String seki_no, String tokutei_cd) {
		super();
		this.subjects_cd = subjects_cd;
		this.start_date = start_date;
		this.start_time_cd = start_time_cd;
		this.start_time = start_time;
		this.end_time = end_time;
		this.card_start_time = card_start_time;
		this.card_end_time = card_end_time;
		this.room_cd1 = room_cd1;
		this.room_cd2 = room_cd2;
		this.room_cd3 = room_cd3;
		this.cancel_flag = cancel_flag;
		this.message = message;
		this.comment = comment;
		this.seki_no = seki_no;
		this.tokutei_cd = tokutei_cd;
	}



	public JugyoTable(String subjects_cd, String start_date, String start_time_cd, String start_time, String end_time,
			String room_cd1, String room_cd2, String room_cd3, String message, String comment, String seki_no,
			String tokutei_cd) {
		super();
		this.subjects_cd = subjects_cd;
		this.start_date = start_date;
		this.start_time_cd = start_time_cd;
		this.start_time = start_time;
		this.end_time = end_time;
		this.room_cd1 = room_cd1;
		this.room_cd2 = room_cd2;
		this.room_cd3 = room_cd3;
		this.message = message;
		this.comment = comment;
		this.seki_no = seki_no;
		this.tokutei_cd = tokutei_cd;
	}



	public String getSubjects_cd() {
		return subjects_cd;
	}

	public void setSubjects_cd(String subjects_cd) {
		this.subjects_cd = subjects_cd;
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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCard_start_time() {
		return card_start_time;
	}

	public void setCard_start_time(String card_start_time) {
		this.card_start_time = card_start_time;
	}

	public String getCard_end_time() {
		return card_end_time;
	}

	public void setCard_end_time(String card_end_time) {
		this.card_end_time = card_end_time;
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

	public String getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(String cancel_flag) {
		this.cancel_flag = cancel_flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSeki_no() {
		return seki_no;
	}

	public void setSeki_no(String seki_no) {
		this.seki_no = seki_no;
	}

	public String getTokutei_cd() {
		return tokutei_cd;
	}

	public void setTokutei_cd(String tokutei_cd) {
		this.tokutei_cd = tokutei_cd;
	}





}
