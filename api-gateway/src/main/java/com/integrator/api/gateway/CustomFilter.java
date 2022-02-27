package com.integrator.api.gateway;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class CustomFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //set security and Authorization here as well as log , this is before request is sent
        //you can set if statements to filter in different services and choose different actions
        //eg if(request.getURI().toString().contains("/api/orders/")){ do something}
        //otherwise the actions below will be executed for all the services the same, the same can be said for the
        //response as well
        logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            //This is before response is sent so we can log the response code
            ServerHttpResponse response = exchange.getResponse();

            //just loging http status code as an example
            logger.info("Post Filter = " + response.getStatusCode());

        }));
    }
}
