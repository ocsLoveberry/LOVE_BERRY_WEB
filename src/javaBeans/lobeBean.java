package javaBeans;

public class lobeBean {

	private String LOBE_ID;
	private String ROOM_CD;

	public String getLOBE_ID() {
		return LOBE_ID;
	}
	public void setLOBE_ID(String lOBE_ID) {
		LOBE_ID = lOBE_ID;
	}
	public String getROOM_CD() {
		return ROOM_CD;
	}
	public void setROOM_CD(String ROOM_CD) {
		this.ROOM_CD = ROOM_CD;
	}
	public lobeBean(String lOBE_ID, String ROOM_CD) {
		super();
		LOBE_ID = lOBE_ID;
		this.ROOM_CD = ROOM_CD;
	}


}
