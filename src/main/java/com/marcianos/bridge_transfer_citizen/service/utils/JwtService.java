package com.marcianos.bridge_transfer_citizen.service.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final ObjectMapper objectMapper;

    public String getUserId(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Token not present or incorrectly formed");
        }

        String token = authorizationHeader.substring(7);
        String[] partes = token.split("\\.");

        if (partes.length != 3) {
            throw new RuntimeException("Incorrectly formed JWT token");
        }

        try {
            String payloadJson = new String(Base64.getUrlDecoder().decode(partes[1]));
            Map<String, Object> claims = objectMapper.readValue(payloadJson, Map.class);

            Object userId = claims.get("user_id");
            if (userId == null) {
                userId = claims.get("sub");
            }

            if (userId == null) {
                throw new RuntimeException("User ID not found in token");
            }

            return userId.toString();

        } catch (Exception e) {
            throw new RuntimeException("Token could not be decoded: " + e.getMessage());
        }
    }
}
