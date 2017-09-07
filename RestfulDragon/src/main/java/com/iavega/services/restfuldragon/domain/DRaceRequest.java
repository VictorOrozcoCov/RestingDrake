package com.iavega.services.restfuldragon.domain;

import java.util.List;

public class DRaceRequest {
	private List<String> name;

	public DRaceRequest() {
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DRaceRequest [name=" + name + "]";
	}
}
