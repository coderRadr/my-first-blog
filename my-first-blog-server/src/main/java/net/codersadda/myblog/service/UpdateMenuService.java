package net.codersadda.myblog.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import net.codersadda.myblog.entity.ConstantUtil;
import net.codersadda.myblog.entity.Menu;
import net.codersadda.myblog.entity.MenuDb;
import net.codersadda.myblog.entity.UIMenuItem;
import net.codersadda.myblog.repository.WebMenuRepository;

@Component
public class UpdateMenuService {

	@Value("${spring.datasource.url}")
	private String jdbcConnection;

	@Value("${spring.datasource.username}")
	private String jdbcUserId;

	@Value("${spring.datasource.password}")
	private String jdbcPwd;


	private String getMenuItems = "call getLeftNav()";

	@Autowired
	private WebMenuRepository repository;

	public String insertIntoMenu(List<Menu> screens) {
		for (Menu menu : screens) {
			try {
				repository.save(new MenuDb(menu.getScreenId(), menu.getScreenName(), menu.getParentscreenid(),
						new Date(), new Date()));
			} catch (Exception e) {
				return ConstantUtil.DBERROR.response();
			}
		}
		return ConstantUtil.DBSUCCESS.response().concat(": ").concat(String.valueOf(screens.size()));
	}

	public void deleteMenu(List<String> screenNames) {
		for (String name : screenNames) {
			try {
				List<MenuDb> entryToDelete = repository.findByscreenName(name);
				repository.delete(entryToDelete.get(0));
			} catch (Exception e) {
				throw new RestClientException(
						ConstantUtil.DBERROR.response().concat(": ").concat(e.getLocalizedMessage()));
			}

		}
	}

	public List<UIMenuItem> getScreenInfo() {
		CallableStatement statement = null;
		List<UIMenuItem> menuList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(jdbcConnection, jdbcUserId, jdbcPwd);
			statement = conn.prepareCall(getMenuItems);
			statement.execute();
			List<MenuDb> menuItems = new ArrayList<>();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				menuItems.add(new MenuDb(rs.getInt("screenid"), rs.getString("screenname"), rs.getInt("parentscreenid"),
						rs.getDate("createdtimestamp"), rs.getDate("updatedtimestamp")));
			}
			for (MenuDb menuDb : menuItems) {
				List<String> subScreenNames = new ArrayList<>();
				List<MenuDb> subscreens = menuItems.stream()
						.filter(src -> src.getParentscreenid() == menuDb.getScreenId()).collect(Collectors.toList());
				subscreens.stream().forEach(src -> subScreenNames.add(src.getScreenName()));
				menuList.add(new UIMenuItem(menuDb.getScreenName(), subScreenNames));
			}
			menuList.removeIf(src -> src.getSubScreens().isEmpty());
		} catch (Exception e) {
			throw new RestClientException(e.getLocalizedMessage());
		} 
		return menuList;
	}

}
