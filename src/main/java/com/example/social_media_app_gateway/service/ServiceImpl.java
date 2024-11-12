package com.example.social_media_app_gateway.service;

import com.example.social_media_app_gateway.blacklist.CacheConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ServiceImpl implements Service{
    private final CacheConfig cacheConfig;

    @Override
    public Mono<Void> logout(String accessToken) {
        return Mono.just(accessToken)
                .doOnNext(s -> cacheConfig.putToLogOutAccountBlackList(accessToken))
                .then();
    }
}
