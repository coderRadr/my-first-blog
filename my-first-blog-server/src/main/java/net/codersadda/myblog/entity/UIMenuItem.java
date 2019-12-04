package net.codersadda.myblog.entity;

import java.util.List;

public class UIMenuItem {
	private String screenName;
	private List<String> subScreens;

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<String> getSubScreens() {
		return subScreens;
	}

	public void setSubScreens(List<String> subScreens) {
		this.subScreens = subScreens;
	}

	public UIMenuItem(String screenName, List<String> subScreens) {
		super();
		this.screenName = screenName;
		this.subScreens = subScreens;
	}

	public UIMenuItem() {
		super();
	}

}
