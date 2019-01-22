package javaBeans;

public class OcsJohoData {

	private String seki_no;
	private String type;
	private String name;
	private String mail_adress;
	private String comment;

	public OcsJohoData(){
	}

	public OcsJohoData(String seki_no,String name,String comment){
		setSeki_no(seki_no);
		setName(name);
		setComment(comment);
//		setType(type);
//		setMail_adress(mail_adress);
	}

	public OcsJohoData(String seki_no, String type, String name, String mail_adress, String comment) {
		super();
		this.seki_no = seki_no;
		this.type = type;
		this.name = name;
		this.mail_adress = mail_adress;
		this.comment = comment;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMAIL_ADDRESS() {
		return mail_adress;
	}

	public void setMAIL_ADDRESS(String mail_adress) {
		this.mail_adress = mail_adress;
	}
}
