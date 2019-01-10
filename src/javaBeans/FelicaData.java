package javaBeans;

public class FelicaData {

	private String seki_no;
	private String idm1;
	private String idm2;
	private String comment1;
	private String comment2;

	public FelicaData(String seki_no, String idm1, String idm2, String comment1, String comment2) {
		super();
		this.seki_no = seki_no;
		this.idm1 = idm1;
		this.idm2 = idm2;
		this.comment1 = comment1;
		this.comment2 = comment2;
	}

	public String getSeki_no() {
		return seki_no;
	}

	public void setSeki_no(String seki_no) {
		this.seki_no = seki_no;
	}

	public String getIdm1() {
		return idm1;
	}

	public void setIdm1(String idm1) {
		this.idm1 = idm1;
	}

	public String getIdm2() {
		return idm2;
	}

	public void setIdm2(String idm2) {
		this.idm2 = idm2;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

}
