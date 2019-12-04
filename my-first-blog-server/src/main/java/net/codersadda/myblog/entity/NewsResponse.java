package net.codersadda.myblog.entity;

import java.util.List;

public class NewsResponse {

	private String category;

	private List<Sources> sources;

	public String getStatus() {
		return category;
	}

	public void setStatus(String status) {
		this.category = status;
	}

	public List<Sources> getSources() {
		return sources;
	}

	public void setSources(List<Sources> sources) {
		this.sources = sources;
	}

}
