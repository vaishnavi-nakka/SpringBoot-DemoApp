package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Null;


@Entity
public class Choice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qid;
	private String choice;
	private String defaultvalue;
	private String choicevalue;
	private String corder;
	private String lastupdatedateATTuid;
	private String lastupdatedate;
	private String createdate;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public String getChoicevalue() {
		return choicevalue;
	}
	public void setChoicevalue(String choicevalue) {
		this.choicevalue = choicevalue;
	}
	public String getCorder() {
		return corder;
	}
	public void setCorder(String corder) {
		this.corder = corder;
	}
	public String getLastupdatedateATTuid() {
		return lastupdatedateATTuid;
	}
	public void setLastupdatedateATTuid(String lastupdatedateATTuid) {
		this.lastupdatedateATTuid = lastupdatedateATTuid;
	}
	public String getLastupdatedate() {
		return lastupdatedate;
	}
	public void setLastupdatedate(String lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Choice [id=" + id + ", qid=" + qid + ", choice=" + choice + ", defaultvalue=" + defaultvalue
				+ ", choicevalue=" + choicevalue + ", corder=" + corder + ", lastupdatedateATTuid="
				+ lastupdatedateATTuid + ", lastupdatedate=" + lastupdatedate + ", createdate=" + createdate + "]";
	}
	
	
	
	

}
