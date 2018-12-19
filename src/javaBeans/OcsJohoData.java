package javaBeans;

public class studentData {

	private String name;
	private String seki_no;
	private String comment;

	public studentData(){

	}

	public studentData(String name,String seki_no,String comment){
		setName(name);
		setSeki_no(seki_no);
		setComment(comment);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeki_no() {
		return seki_no;
	}
	public void setSeki_no(String seki_no) {
		this.seki_no = seki_no;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


}
