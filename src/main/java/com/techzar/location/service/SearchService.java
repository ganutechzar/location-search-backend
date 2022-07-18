package com.techzar.location.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techzar.location.dto.Search;
import com.techzar.location.dto.response.SearchResponse;
import com.techzar.location.repository.SearchRepository;

@Service
public class SearchService {
	@Value("${Location.key}")
	private String key_id;
	
	@Autowired
	private SearchRepository repo;
	
	public List<SearchResponse> getLocaionData(String data) throws Exception {
		try {
			String url = "http://api.positionstack.com/v1/forward?access_key="+ key_id +"&query="+data;			
			RestTemplate client = new RestTemplate();
			Object result = client.getForObject(url, Object.class);
			ObjectMapper objMap = new ObjectMapper();
			Map<String, Object> locationMap = objMap.convertValue(result, Map.class);
			List<SearchResponse> response = new ArrayList<SearchResponse>();
			int i = 1;
			for(Object obj : objMap.convertValue(locationMap.get("data"), List.class)) {
				Map<String, Object> area = objMap.convertValue(obj, Map.class);
				System.out.println(area);
				response.add(new SearchResponse(i,area.get("name").toString()+","+ area.get("region").toString()));
				i++;				
			}
			
		    return response;
	    }catch (UnprocessableEntity ex) {			
			return null;
		}catch (Exception e) {
			throw e;
		}
	}

	public void saveSearchData(Search data) {
		repo.save(data);
	}
}
