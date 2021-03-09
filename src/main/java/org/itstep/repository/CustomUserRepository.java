package org.itstep.repository;

import org.itstep.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findUserByUsername(String username);
}
