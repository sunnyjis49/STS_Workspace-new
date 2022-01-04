package com.sun.microservice.photoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>{
	
	@Autowired
	private Environment environment;
	
	public AuthorizationHeaderFilter() {
		super(Config.class);
	}
	
	public static class Config{
		//Put configuration properties here
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			if(!request.getHeaders().containsKey("Authorization")) {
				return onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
			}
			
			String authorizationHeader = request.getHeaders().get("Authorization").get(0);
			String jwt = authorizationHeader.replace("Bearer ", "");
			if(!isJwtValid(jwt)) {
				return onError(exchange, "JWT token is not valid", HttpStatus.UNAUTHORIZED);
			}
			return chain.filter(exchange);
		};
	}

	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
		// TODO Auto-generated method stub
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(httpStatus);
		return response.setComplete();
	}
	
	private boolean isJwtValid(String jwt) {
		boolean returnValue = Boolean.TRUE;
		String subject = null;
		
		try {
			subject = Jwts.parser().setSigningKey(environment.getProperty("token.secret"))
			.parseClaimsJws(jwt)
			.getBody()
			.getSubject();
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			returnValue = Boolean.FALSE;
		}
		
		if(subject == null || subject.isEmpty()) {
			returnValue = Boolean.FALSE;
		}
		return returnValue;
	}

}
