package com.wyj.config;

import com.wyj.service.SSOService;
import com.wyj.factory.SSOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SSOFactory ssoFactory() {
        SSOFactory ssoFactory = new SSOFactory();
        return ssoFactory;
    }

    @Bean
    public SSOService ssoService(@Value("${sso.storeType}") String storeType, @Autowired SSOFactory ssoFactory) {
        return ssoFactory.getStore(storeType);
    }

}
