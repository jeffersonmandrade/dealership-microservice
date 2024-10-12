package com.app.gateway.security;

import com.app.gateway.service.JwtUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
public class UserAuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<UserAuthenticationGatewayFilterFactory.Config> {
    private final JwtUtil jwtUtil;

    public UserAuthenticationGatewayFilterFactory(JwtUtil jwtUtil) {
        super(Config.class);
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return(exchange, chain) ->  {
            try{

                String accessToken = exchange.getRequest().getHeaders()
                        .get(config.getHeaderName()).stream().findFirst().orElseThrow();
                String user = jwtUtil.decodeToken(accessToken);
                exchange.getRequest().mutate().header("userID", user).build();
                return chain.filter(exchange);
            }catch (Exception e){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        };
    }

    @Getter
    @Setter
    @Builder
    public static class Config {
        private String headerName;
    }
}
