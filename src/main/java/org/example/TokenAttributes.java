package org.example;

public record TokenAttributes(String access_token,
                            String token_type,
                            int expires_in) {
}
