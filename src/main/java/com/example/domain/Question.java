package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	private String question;
	private String questionType;
	private String required;
	private String hidden;
	private String onchange;
	private String aotsfield;
	private String from_ticket;
	private String lastupdatedateAttuid;
	private int tid;
	private String qorder;
	private String lastupdatedate;
	private String createdate;
	private String include_question;
	
	
	

	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getOnchange() {
		return onchange;
	}
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}
	public String getAotsfield() {
		return aotsfield;
	}
	public void setAotsfield(String aotsfield) {
		this.aotsfield = aotsfield;
	}
	public String getFrom_ticket() {
		return from_ticket;
	}
	public void setFrom_ticket(String from_ticket) {
		this.from_ticket = from_ticket;
	}
	public String getLastupdatedateAttuid() {
		return lastupdatedateAttuid;
	}
	public void setLastupdatedateAttuid(String lastupdatedateAttuid) {
		this.lastupdatedateAttuid = lastupdatedateAttuid;
	}
	

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getQorder() {
		return qorder;
	}
	public void setQorder(String qorder) {
		this.qorder = qorder;
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
	public String getInclude_question() {
		return include_question;
	}
	public void setInclude_question(String include_question) {
		this.include_question = include_question;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", questionType=" + questionType + ", required="
				+ required + ", hidden=" + hidden + ", onchange=" + onchange + ", aotsfield=" + aotsfield
				+ ", from_ticket=" + from_ticket + ", lastupdatedateAttuid=" + lastupdatedateAttuid + ", tid=" + tid
				+ ", aorder=" + qorder + ", lastupdatedate=" + lastupdatedate + ", createdate=" + createdate
				+ ", include_question=" + include_question + "]";
	}
	
	

}
