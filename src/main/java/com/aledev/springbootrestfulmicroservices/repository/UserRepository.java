package com.aledev.springbootrestfulmicroservices.repository;

import com.aledev.springbootrestfulmicroservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
