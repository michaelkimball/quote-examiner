package dev.michaelkimball.opennlp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(a -> a
                    .antMatchers("/", "/error", "/static/**", "/favicon.ico").permitAll()
                    .anyRequest().authenticated()
            )
            .logout(l -> l
                    .logoutSuccessUrl("/").permitAll()
            )
            .csrf(c -> c
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            )
            .exceptionHandling(e -> e
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            )
            .oauth2Login()
            .failureHandler((request, response, exception) -> {
                log.error("oauth failed", exception);
            });
    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService(){
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return request -> {
          OAuth2User user = delegate.loadUser(request);
          Map<String, Object> attributes = new HashMap<>(user.getAttributes());
          if("github".equals(request.getClientRegistration().getRegistrationId())){
              attributes.put("sub", attributes.get("id"));
          }
          attributes.put("oauthId", request.getClientRegistration().getRegistrationId() + attributes.get("sub"));
          user = new DefaultOAuth2User(user.getAuthorities(), attributes, "oauthId");
          return user;
        };
    }
}
