package org.fao.security.azure;
/*
import java.util.HashSet;
import java.util.Set;

import org.fao.security.azure.support.GroupsClaimMapper;
import org.fao.security.azure.support.NamedOidcUser;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableConfigurationProperties(JwtAuthorizationProperties.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtAuthorizationConfiguration {

	@Bean
    SecurityFilterChain customJwtSecurityChain(HttpSecurity http, JwtAuthorizationProperties props) throws Exception {
        // @formatter:off
        return http
          .authorizeRequests( r -> r.anyRequest().authenticated())
          .oauth2Login(oauth2 -> {
              oauth2.userInfoEndpoint(ep -> 
                ep.oidcUserService(customOidcUserService(props)));
          })
        .build();
        // @formatter:on
    }
	
	private OAuth2UserService<OidcUserRequest, OidcUser> customOidcUserService(JwtAuthorizationProperties props) {
        final OidcUserService delegate = new OidcUserService();
        final GroupsClaimMapper mapper = new GroupsClaimMapper(
          props.getAuthoritiesPrefix(), 
          props.getGroupsClaim(),
          props.getGroupToAuthorities());
        
        return (userRequest) -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);
            // Enrich standard authorities with groups 
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            mappedAuthorities.addAll(oidcUser.getAuthorities());
            mappedAuthorities.addAll(mapper.mapAuthorities(oidcUser));
            
            oidcUser = new NamedOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo(),oidcUser.getName());

            return oidcUser;
        };
    }
	

}
*/