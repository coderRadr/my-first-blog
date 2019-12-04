package net.codersadda.myblog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.codersadda.myblog.entity.MenuDb;


public interface WebMenuRepository extends CrudRepository<MenuDb, Integer>{
	
	public List<MenuDb> findByscreenName(@Param("screenName") String screenName);

}
