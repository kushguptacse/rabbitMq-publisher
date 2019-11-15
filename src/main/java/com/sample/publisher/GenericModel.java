package com.sample.publisher;

import java.io.Serializable;

public class GenericModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1504079919931563272L;
	private String content;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[content=" + content + "]";
	}

}
