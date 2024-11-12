package com.example.social_media_app_gateway.blacklist;

public interface CacheConfig {
    void putToLogOutAccountBlackList(String accessToken);
}
