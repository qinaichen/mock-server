package com.funshion.config;

import com.funshion.controller.SimpleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SimpleRouter {

    @Autowired
    private SimpleHandler simpleHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route(RequestPredicates.GET("/api/**"),simpleHandler::getData);
    }
}
