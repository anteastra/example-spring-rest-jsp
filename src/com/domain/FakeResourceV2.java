package com.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FakeVersion")
@XmlAccessorType(XmlAccessType.FIELD)
public class FakeResourceV2 {

	@XmlElement(name = "name", required = true)
	private String name;
	@XmlElement(name = "description", required = true)
	private String description;
	
	public FakeResourceV2() {
		super();
	}
	
	public FakeResourceV2(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
}
