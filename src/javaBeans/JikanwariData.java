package javaBeans;

public class JikanwariData {
	public String id;
	public String title;
	public String start;
	public String end;
	public String color;
	public String url;

	public JikanwariData() {}
	public JikanwariData(String title, String start) {
		super();
		this.title = title;
		this.start = start;
	}

	public JikanwariData(String title, String start,String end) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
	}

	public JikanwariData(String title, String start,String end,String url) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
