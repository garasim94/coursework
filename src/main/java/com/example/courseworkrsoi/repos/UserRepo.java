package com.example.courseworkrsoi.repos;

import com.example.courseworkrsoi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
