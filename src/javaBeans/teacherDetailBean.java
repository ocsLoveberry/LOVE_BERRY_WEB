package javaBeans;

public class teacherDetailBean {
	private String seki_no;
	private String name;
	private String message;
	private String teacherFelicaID1;
	private String teacherFelicaID2;

	public teacherDetailBean(String seki_no, String name, String message, String teacherFelicaID1,
			String teacherFelicaID2) {
		super();
		this.seki_no = seki_no;
		this.name = name;
		this.message = message;
		this.teacherFelicaID1 = teacherFelicaID1;
		this.teacherFelicaID2 = teacherFelicaID2;
	}

	public teacherDetailBean(String seki_no, String name, String teacherFelicaID1, String teacherFelicaID2) {
		super();
		this.seki_no = seki_no;
		this.name = name;
		this.teacherFelicaID1 = teacherFelicaID1;
		this.teacherFelicaID2 = teacherFelicaID2;
	}

	public teacherDetailBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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


	public String getTeacherFelicaID1() {
		return teacherFelicaID1;
	}


	public void setTeacherFelicaID1(String teacherFelicaID1) {
		this.teacherFelicaID1 = teacherFelicaID1;
	}


	public String getTeacherFelicaID2() {
		return teacherFelicaID2;
	}


	public void setTeacherFelicaID2(String teacherFelicaID2) {
		this.teacherFelicaID2 = teacherFelicaID2;
	}

}