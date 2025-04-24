package com.example.db_sqp.repository;

import com.example.db_sqp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
