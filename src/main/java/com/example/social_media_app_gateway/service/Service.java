package com.example.social_media_app_gateway.service;

import reactor.core.publisher.Mono;

public interface Service {
    Mono<Void> logout(String accessToken);
}
