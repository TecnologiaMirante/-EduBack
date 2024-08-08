package br.com.mirante.eduapi.feignclient;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TokenFilter implements Filter {

    private static final ThreadLocal<String> tokenHolder = new ThreadLocal<>();

    public static String getToken() {
        return tokenHolder.get();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("Authorization");
        tokenHolder.set(token);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Não é necessário implementar init neste caso
    }

    @Override
    public void destroy() {
        tokenHolder.remove();
    }
}

