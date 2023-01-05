package com.alevel.backend.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CertifiedRepository extends JpaRepository<Certified, Long> {

    Optional<Certified> findByEmail(String email);

    Optional<Certified> findTop1ByEmailAndTokenAndExpirationDateAfterAndExpiredOrderByExpirationDateDesc(
            String email,
            String token,
            LocalDateTime expirationDate,
            boolean expired
    );
}
