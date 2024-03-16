package com.agora.springapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVerifierRepository extends JpaRepository<users, String> {
    boolean existsByUnameAndPassword(String uname, String password);
}