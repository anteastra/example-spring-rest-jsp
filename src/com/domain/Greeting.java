package com.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {
	
	public Greeting() {
		super();
	}

	private long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    @XmlAttribute
    public String getContent() {
        return content;
    }
}
