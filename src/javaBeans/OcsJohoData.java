package javaBeans;

public class OcsJohoData {

	private String seki_no;
	private String type;
	private String name;
	private String message;
	private String mail_address;
	private String password;
	private String gakka_cd;
	private String senko_cd;
	private String class_cd;
	private String year;

	public OcsJohoData(){
	}

	public OcsJohoData(String seki_no,String name,String message){
		setSeki_no(seki_no);
		setName(name);
		setMessage(message);
//		setType(type);
//		setMail_adress(mail_adress);
	}

	public OcsJohoData(String seki_no, String type, String name, String mail_address, String comment) {
		super();
		this.seki_no = seki_no;
		this.type = type;
		this.name = name;
		this.mail_address = mail_address;
		this.message = comment;
	}


	public OcsJohoData(String seki_no, String type, String name, String comment, String mail_address, String password,
			String gakka_cd, String senko_cd, String class_cd, String year) {
		super();
		this.seki_no = seki_no;
		this.type = type;
		this.name = name;
		this.message = comment;
		this.mail_address = mail_address;
		this.password = password;
		this.gakka_cd = gakka_cd;
		this.senko_cd = senko_cd;
		this.class_cd = class_cd;
		this.year = year;
	}

	public String getSeki_no() {
		return seki_no;
	}

	public void setSeki_no(String seki_no) {
		this.seki_no = seki_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGakka_cd() {
		return gakka_cd;
	}

	public void setGakka_cd(String gakka_cd) {
		this.gakka_cd = gakka_cd;
	}

	public String getSenko_cd() {
		return senko_cd;
	}

	public void setSenko_cd(String senko_cd) {
		this.senko_cd = senko_cd;
	}

	public String getClass_cd() {
		return class_cd;
	}

	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
