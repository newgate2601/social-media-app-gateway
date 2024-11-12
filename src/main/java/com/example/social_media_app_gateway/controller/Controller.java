package com.example.social_media_app_gateway.controller;

import com.example.social_media_app_gateway.common.Constants;
import com.example.social_media_app_gateway.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("services/gateway/logout")
@AllArgsConstructor
public class Controller {
    private final Service service;

    @PostMapping("/log-out")
    public Mono<Void> logout(@RequestHeader(Constants.AUTHORIZATION) String accessToken) {
        return service.logout(accessToken);
    }
}
