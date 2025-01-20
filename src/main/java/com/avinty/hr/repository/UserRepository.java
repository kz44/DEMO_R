package com.avinty.hr.repository;

import com.avinty.hr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
