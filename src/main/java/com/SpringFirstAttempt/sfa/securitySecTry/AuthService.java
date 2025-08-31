package com.SpringFirstAttempt.sfa.securitySecTry;

public class AuthService {

    private final userRepository2 userRepository2;

    private final TokenRepository tokenRepository;

    public AuthService(com.SpringFirstAttempt.sfa.securitySecTry.userRepository2 userRepository2, TokenRepository tokenRepository) {
        this.userRepository2 = userRepository2;
        this.tokenRepository = tokenRepository;
    }
}
