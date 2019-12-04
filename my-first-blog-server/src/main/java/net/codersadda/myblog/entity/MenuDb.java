package net.codersadda.myblog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "webmenu")
@Getter
@Setter
public class MenuDb {
	@Id
	@Column(name = "screenid", unique = true, nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int screenId;

	@Column(name = "screenname", unique = true, nullable = false)
	private String screenName;

	@Column(name = "parentscreenid", unique = false, nullable = true)
	private int parentscreenid;

	@Column(name = "createdtimestamp", unique = true, nullable = false)
	@CreationTimestamp
	private Date createdTimeStamp;

	@Column(name = "updatedtimestamp", unique = true, nullable = false)
	@UpdateTimestamp
	private Date updatedTimeStamp;

	public MenuDb(int screenId, String screenName, int parentscreenid, Date createdTimeStamp, Date updatedTimeStamp) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.parentscreenid = parentscreenid;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public MenuDb() {
		super();
	}

}
