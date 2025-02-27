package com.zosh.treading.config;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String jwt = request.getHeader("Authorization");

        // 'Bearer joken'
        if (jwt != null) {
            jwt = jwt.substring(7);
            try {

            } catch (Exception e) {
                throw new RuntimeException("Invalid token");
            }
        }
    }

}
