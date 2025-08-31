package com.SpringFirstAttempt.sfa.securitySecTry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository2 extends JpaRepository<User2, Integer> {

    //El objeto optional puede ser nulo o no y es una forma moderna no hacer verificación manual
    //de que el dato no sea nulo
    Optional<User2> findByEmail(String email);
}
