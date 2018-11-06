package com.funshion.controller;

import com.alibaba.fastjson.JSON;
import com.funshion.dao.ItemDao;
import com.funshion.model.Item;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

@Component
public class SimpleHandler {


    @Autowired
    private ItemDao itemDao;

    public Mono<ServerResponse> getData(ServerRequest request){
        ServerResponse.BodyBuilder builder = ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .header("addition-info","D72247C59747966796473616E2F676D696E26747E616E65786E2D6F63622A32256C646E6572622B7");
        String result = JSON.toJSONString(ImmutableMap.of("code",404,"msg","找不到相应的配置"));
        Optional<String> delay = request.queryParam("time");
        Long timeout = 0l;
        if(delay.isPresent()){
            timeout = Long.parseLong(delay.get());
        }
        String path = request.uri().getPath();
        String uri = path.substring(4,path.length());
        Mono<Item> item = this.itemDao.findByPath(uri);
        return builder.body(item.map(Item::getCode).defaultIfEmpty(result),String.class).delayElement(Duration.ofMillis(timeout));
    }
}
