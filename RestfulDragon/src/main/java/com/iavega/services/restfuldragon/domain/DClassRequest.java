package com.iavega.services.restfuldragon.domain;

import java.util.List;

public class DClassRequest {
	private List<String> name;

	public DClassRequest() {

	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DClassRequest [name=" + name + "]";
	}

}
