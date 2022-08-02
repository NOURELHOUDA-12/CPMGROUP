package com.example.cpmpgroup.dao.repository;

import com.example.cpmpgroup.dao.models.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Email,Long> {
}
