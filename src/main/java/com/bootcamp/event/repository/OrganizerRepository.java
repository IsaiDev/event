package com.bootcamp.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.event.domain.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
