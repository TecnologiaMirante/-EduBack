package br.com.mirante.eduapi.feignclient;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class AutenticacaoConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = TokenFilter.getToken();
            if (token != null) {
                requestTemplate.header("Authorization", token);
            }
        };
    }
}
