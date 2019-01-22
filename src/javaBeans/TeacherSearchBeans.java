package javaBeans;

//		教員検索用Beans
public class TeacherSearchBeans {
	private String seki_no;
	private String name;
	private String mail_address;
	private String massage;

	public TeacherSearchBeans() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public TeacherSearchBeans(String seki_no, String name, String mail_address, String massage) {
		super();
		this.seki_no = seki_no;
		this.name = name;
		this.mail_address = mail_address;
		this.massage = massage;
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

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

}
