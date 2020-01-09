package com.zywz.gateway.filter;

import com.zywz.common.util.FastJsonUtils;
import com.zywz.common.util.Response;
import com.zywz.common.util.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class JWTAuthFilter implements GlobalFilter, Ordered {
    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();

        //忽略以下url请求
        if(url.indexOf("/auth/") >= 0){
            return chain.filter(exchange);
        }

        //从请求头中取得token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if(StringUtils.isEmpty(token)){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

            Response res = new Response(ResponseCode.ERROR_NO_TOKEN,null);

            byte[] responseByte = FastJsonUtils.toJSONNoFeatures(res).getBytes(StandardCharsets.UTF_8);

            DataBuffer buffer = response.bufferFactory().wrap(responseByte);
            return response.writeWith(Flux.just(buffer));
        }

        /**
         * 验证token是否合法
         * 比对redis中数据
         * TODO
         */

//        String id = JJWTUtils.getClaimjti(token);
//        boolean verifyResult = JJWTUtils.isTokenExpired(token);
        if(false){

            //判断是否在有效缓存

            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

            Response res = new Response(ResponseCode.ERROR_INVALID_TOKEN,null);

            byte[] responseByte = FastJsonUtils.toJSONNoFeatures(res).getBytes(StandardCharsets.UTF_8);

            DataBuffer buffer = response.bufferFactory().wrap(responseByte);
            return response.writeWith(Flux.just(buffer));
        }

        return chain.filter(exchange);
    }
}
