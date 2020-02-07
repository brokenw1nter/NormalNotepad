package models;

import java.io.Serializable;

public class Document implements Serializable {
	
	protected String content;
	private static final long serialVersionUID = -606912658139568881L;
	
	public Document() {}
	
	public Document(String content) {
		this.setContent(content);
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getContent());
		return sb.toString();
	}
	
}