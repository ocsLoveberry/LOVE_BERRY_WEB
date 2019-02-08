package javaBeans;

public class TimeListTable {

	private String time_cd;
	private String start_time;
	private String end_time;
	private String card_start_time;
	private String card_end_time;
	private String card_late_time;

	public TimeListTable(String time_cd, String start_time, String end_time, String card_start_time,
			String card_end_time) {
		super();
		this.time_cd = time_cd;
		this.start_time = start_time;
		this.end_time = end_time;
		this.card_start_time = card_start_time;
		this.card_end_time = card_end_time;
	}

	public String getTime_cd() {
		return time_cd;
	}

	public void setTime_cd(String time_cd) {
		this.time_cd = time_cd;
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

	public String getCard_late_time() {
		return card_late_time;
	}

	public void setCard_late_time(String card_late_time) {
		this.card_late_time = card_late_time;
	}




}
