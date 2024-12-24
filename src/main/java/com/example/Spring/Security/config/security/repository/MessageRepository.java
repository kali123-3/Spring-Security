package com.example.Spring.Security.config.security.repository;

import com.example.Spring.Security.config.security.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}