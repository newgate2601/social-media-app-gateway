package com.example.social_media_app_gateway.blacklist.caffeine;

import com.example.social_media_app_gateway.blacklist.CacheConfig;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CaffeineBlackListImpl implements CacheConfig {
    private final Cache<String, Boolean> logOutAccountBlackList;
    private final JwtDecoder jwtDecoder;

    @Override
    public void putToLogOutAccountBlackList(String accessToken){
        Jwt jwt = jwtDecoder.decode(accessToken);
        String jti = (String) jwt.getClaims().get("jti");
        logOutAccountBlackList.put(jti, true);
//        logOutAccountBlackList.put(accessToken, true);
        print();
    }

    private void print(){
        log.error("Log out blacklist successful !!!");
        logOutAccountBlackList.asMap().forEach((jtI, b) -> {
            System.out.println("key: " + jtI);
        });
    }
}

