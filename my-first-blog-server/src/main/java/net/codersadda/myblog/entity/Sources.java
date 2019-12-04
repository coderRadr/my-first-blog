package net.codersadda.myblog.entity;

public class Sources {

	private String headLines;
	private String article;
	private String url;
	private String category;
	private String language;

	public String getId() {
		return headLines;
	}

	public void setId(String id) {
		this.headLines = id;
	}

	public String getName() {
		return article;
	}

	public void setName(String name) {
		this.article = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Sources(String headLines, String article, String url, String category, String language) {
		super();
		this.headLines = headLines;
		this.article = article;
		this.url = url;
		this.category = category;
		this.language = language;
	}

}
