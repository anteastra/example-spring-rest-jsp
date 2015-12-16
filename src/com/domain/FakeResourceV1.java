package com.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FakeVersion")
@XmlAccessorType(XmlAccessType.FIELD)
public class FakeResourceV1 {
	
	@XmlElement(name = "name", required = true)
	private String name;

	public FakeResourceV1(String name) {
		super();
		this.name = name;
	}
	
	public FakeResourceV1() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
