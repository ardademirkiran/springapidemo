package com.agora.springapi.repository;

import com.agora.springapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    boolean existsByUnameAndPassword(String uname, String password);

    boolean existsByUname(String uname);

    boolean existsByEmail(String email);
}