package com.funshion.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "item")
public class Item {

	@Id
	private String id;

	private String name;
	
	private String path;

	private String code;



}
