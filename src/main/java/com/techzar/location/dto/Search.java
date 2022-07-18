package com.techzar.location.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Search {
	@Id
	@GeneratedValue
	private long id;
	@Lob
	private String userSearch;
	
	public Search() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserSearch() {
		return userSearch;
	}

	public void setUserSearch(String userSearch) {
		this.userSearch = userSearch;
	}
}
