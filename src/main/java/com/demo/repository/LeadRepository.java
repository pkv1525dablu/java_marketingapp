package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
