package com.funshion.controller;


import com.funshion.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.funshion.model.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MockController {
	

	@Autowired
	private ItemDao itemDao;

    @PostMapping("/mock/save")
    public Mono<Item> save(@RequestBody Item item) {
    	return itemDao.save(item);
    }

    @GetMapping("/mock/getAll")
    public Flux<Item> getItems(){
        return itemDao.findAll();
    }

    @PostMapping("/mock/delete")
    public Mono<Void> deleteItem(@RequestBody Item item){
        return this.itemDao.delete(item);
    }




}
