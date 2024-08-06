package br.com.mirante.eduapi.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class KeycloakRealmAccessTokenConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final String resourceClient = "app-educacao";

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt){
        final Map<String, Object> resourceAccess = (Map<String, Object>) jwt.getClaims().get("resource_access");
        final Map<String, Object> resourceAccessRoles = ((Map<String, Object>)resourceAccess.get(resourceClient));
        if(resourceAccessRoles==null) return null;
        return ((List<String>)resourceAccessRoles.get("roles")).stream()
                .map(roleName -> roleName) // prefix to map to a Spring Security "role"
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
