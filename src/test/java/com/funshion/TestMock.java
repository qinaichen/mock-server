package com.funshion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.funshion.model.Item;

public class TestMock {

	@Test
	public void test01() {
		Map<String,Item> MockMap = new HashMap<>();
		MockMap.put("/a", new Item());
		MockMap.put("/b", new Item());
		MockMap.put("/c", new Item());
		MockMap.put("/d", new Item());
		MockMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()).forEach(System.out::println);;
	}
}
