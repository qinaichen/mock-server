package com.funshion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.funshion.model.Item;

@Service
public class MockService {

	private static Map<String,Item> MockMap = new HashMap<>();
	
	
	public void set(Item item) {
		MockMap.put(item.getPath(), item);
	}
	
	public Item get(String path) {
		return MockMap.get(path);
	}
	
	public List<Item> getAll() {
		List<Item> items = MockMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
		return items;
	}

	public void remove(String key){
		MockMap.remove(key);
	}
}
