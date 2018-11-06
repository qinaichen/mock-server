package com.funshion.dao;

import com.funshion.model.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ItemDao extends ReactiveMongoRepository<Item,String> {

    public Mono<Item> findByPath(String path);
}
