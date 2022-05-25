package com.example.oauth2example.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class AuthoritiesController {

    @GetMapping("/api/name")
    public String getName(OAuth2AuthenticationToken token) {
        return token.getPrincipal()
                .getName();
    }

    @GetMapping("/api/authorities")
    public String getAuthorities(OAuth2AuthenticationToken token) {
        return token.getPrincipal()
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }

}
