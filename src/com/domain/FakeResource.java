package com.domain;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "FakeResource")
@XmlAccessorType(XmlAccessType.FIELD)
public class FakeResource {

	@XmlElement(name = "id", required = true)
	private long id;
	@XmlElement(name = "name", required = true)
	private String name;
	@XmlElement(name = "description", required = true)
	private String description;
	
	public FakeResource() {
		super();
	}
	
	public long getId() {
		return id;		
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FakeResource(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
}
