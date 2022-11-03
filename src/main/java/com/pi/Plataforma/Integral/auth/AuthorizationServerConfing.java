package com.pi.Plataforma.Integral.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfing extends AuthorizationServerConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final InfoAdicionalToken infoAdicionalToken;
    private final UserDetailsService loginService;

    public AuthorizationServerConfing(BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, InfoAdicionalToken infoAdicionalToken, UserDetailsService loginService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.infoAdicionalToken = infoAdicionalToken;
        this.loginService = loginService;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Autowired
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("boutiqueApp")
                .secret(passwordEncoder.encode("dTJK;zdXy2@bL*H!"))
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600).
                refreshTokenValiditySeconds(3600);
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));

        endpoints.userDetailsService(loginService);
        endpoints.authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain)
                .reuseRefreshTokens(false);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA);
        jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
        return jwtAccessTokenConverter;
    }
}
