package net.codersadda.myblog.entity;

public class Menu {
	private int screenId;
	private String screenName;
	private int parentscreenid;

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getParentscreenid() {
		return parentscreenid;
	}

	public void setParentscreenid(int parentscreenid) {
		this.parentscreenid = parentscreenid;
	}

	public Menu(int screenId, String screenName, int parentscreenid) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.parentscreenid = parentscreenid;
	}

	public Menu() {
		super();
	}

}
