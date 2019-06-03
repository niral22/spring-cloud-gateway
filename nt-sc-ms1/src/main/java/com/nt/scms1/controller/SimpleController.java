package com.nt.scms1.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nt-ms1")
public class SimpleController {

	@GetMapping(value = "/get-data")
	public Mono<String> getData(ServerHttpRequest request, ServerHttpResponse response) {
		System.out.println("Inside SC-MS1 getData method");
		HttpHeaders headers = request.getHeaders();
		
		headers.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});
		
		ResponseCookie.ResponseCookieBuilder builder = ResponseCookie.from("nt-ms1-cookie", "ntMs1CookieValue");
		ResponseCookie cookie = builder.build();
		response.addCookie(cookie);
		Mono<String> data = Mono.just("Hello from Reactive SC-MS1 getData method!!");
		return data;
	}
}