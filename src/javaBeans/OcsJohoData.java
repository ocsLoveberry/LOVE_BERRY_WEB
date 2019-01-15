package javaBeans;

public class OcsJohoData {

	private String name;
	private String seki_no;
	private String comment;

	public OcsJohoData(){

	}

	public OcsJohoData(String seki_no,String name,String comment){
		setSeki_no(seki_no);
		setName(name);
		setComment(comment);
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


}
