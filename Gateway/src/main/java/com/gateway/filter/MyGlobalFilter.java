package com.gateway.filter;

import com.common.core.constant.Constants;
import com.common.core.utils.TokenUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 在调用chain之前执行的逻辑，比如身份验证、日志记录等
        HttpCookie httpCookie = exchange.getRequest().getCookies().getFirst("Authorization");
        String authorization = httpCookie.getValue();
        boolean verify = TokenUtils.verify(authorization);
        if (!verify) {
            // 身份验证失败，返回401 Unauthorized
//            return exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)
        }
        // 继续过滤器链
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 过滤器的顺序，数字越小优先级越高
        return 0;
    }
}