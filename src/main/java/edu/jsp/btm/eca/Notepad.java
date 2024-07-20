package edu.jsp.btm.eca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notepad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notepadId;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String content;
	
	

	public int getNotepadId() {
		return notepadId;
	}

	public void setNotepadId(int notepadId) {
		this.notepadId = notepadId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
