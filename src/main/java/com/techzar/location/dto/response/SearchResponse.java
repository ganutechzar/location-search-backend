package com.techzar.location.dto.response;

public class SearchResponse {
	private int id;
	private String label;
	
	public SearchResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public SearchResponse(int id, String label) {
		this.id = id;
		this.label = label;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
