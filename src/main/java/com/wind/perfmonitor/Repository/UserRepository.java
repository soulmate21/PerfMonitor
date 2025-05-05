package com.wind.perfmonitor.Repository;

import com.wind.perfmonitor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String username);
}
