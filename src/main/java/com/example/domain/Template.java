package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Template {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String templatename;
	private String udTemplate;
	private String lastupdateAttuid;
	private String lastupdatedate;
	private String createdate;
	private String cbus;
	private String type_of_cbus;
	private String tas;
	


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTemplatename() {
		return templatename;
	}


	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}


	public String getUdTemplate() {
		return udTemplate;
	}


	public void setUdTemplate(String udTemplate) {
		this.udTemplate = udTemplate;
	}


	public String getLastupdateAttuid() {
		return lastupdateAttuid;
	}


	public void setLastupdateAttuid(String lastupdateAttuid) {
		this.lastupdateAttuid = lastupdateAttuid;
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


	public String getCbus() {
		return cbus;
	}


	public void setCbus(String cbus) {
		this.cbus = cbus;
	}


	public String getType_of_cbus() {
		return type_of_cbus;
	}


	public void setType_of_cbus(String type_of_cbus) {
		this.type_of_cbus = type_of_cbus;
	}


	public String getTas() {
		return tas;
	}


	public void setTas(String tas) {
		this.tas = tas;
	}


	@Override
	public String toString() {
		return "Template [id=" + id + ", description=" + description + ", templatename=" + templatename
				+ ", udTemplate=" + udTemplate + ", lastupdateAttuid=" + lastupdateAttuid + ", lastupdatedate="
				+ lastupdatedate + ", createdate=" + createdate + ", cbus=" + cbus + ", type_of_cbus=" + type_of_cbus
				+ ", tas=" + tas + "]";
	}

	
}
