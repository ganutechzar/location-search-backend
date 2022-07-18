package com.techzar.location.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techzar.location.dto.Search;
import com.techzar.location.service.SearchService;

@RestController
@CrossOrigin("*")
public class LocationSearch {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("/search")
	public ResponseEntity<Object> search(@RequestParam String data) {
		try {
			Object locationData = searchService.getLocaionData(data);
			if(locationData != null) {				
				///System.out.println(locationData);
				return new ResponseEntity<Object>(locationData, HttpStatus.OK);
			}		
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/save-search-data")
	public void saveUserSearch(@RequestBody List<String> data) {
		Search search = new Search();
		search.setUserSearch(String.join(",", data));
		searchService.saveSearchData(search);
	}
}
