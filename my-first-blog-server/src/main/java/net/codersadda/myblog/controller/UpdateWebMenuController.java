package net.codersadda.myblog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codersadda.myblog.entity.Menu;
import net.codersadda.myblog.entity.UIMenuItem;
import net.codersadda.myblog.service.UpdateMenuService;

@RestController
@RequestMapping(path="/menu")
@Api(value="Web menu controller")
public class UpdateWebMenuController {
	
	@Resource
	private UpdateMenuService service;
	
	@ApiOperation(value = "Update web menu screens", response = String.class)
	@PostMapping(path="/addNewScreens", produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateWebMenu(@RequestBody List<Menu> screens) {
		return service.insertIntoMenu(screens);
	}
	
	@ApiOperation(value = "Delete web menu screens", response = String.class)
	@DeleteMapping(path="/deleteScreen", produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteMenuItem(@RequestBody List<String> screenNames) {
		service.deleteMenu(screenNames);
	}
	
	@ApiOperation(value = "Update web menu screens", response = String.class)
	@GetMapping(path="/getScreens", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UIMenuItem> getScreens() {
		return service.getScreenInfo();
	}

}
