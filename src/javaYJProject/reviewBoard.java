package javaYJProject;

import javafx.beans.property.SimpleStringProperty;

public class reviewBoard {
	private SimpleStringProperty title;
	private SimpleStringProperty writeDate;
	private SimpleStringProperty content;

	reviewBoard(String title,  String writeDate, String content) {
		this.title = new SimpleStringProperty(title);
		this.writeDate = new SimpleStringProperty(writeDate);
		this.content = new SimpleStringProperty(content);
	}

	// title
	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getTitle() {
		return this.title.get();
	}

	public SimpleStringProperty titleProperty() {
		return this.title;
	}

	// Date
	public void setWriteDate(String writeDate) {
		this.writeDate.set(writeDate);
	}

	public String getWriteDate() {
		return this.writeDate.get();
	}

	public SimpleStringProperty writeDateProperty() {
		return this.writeDate;
	}
	
	// content
	public void setContent(String content) {
		this.content.set(content);
	}

	public String getContent() {
		return this.content.get();
	}

	public SimpleStringProperty contentProperty() {
		return this.content;
	}
}
