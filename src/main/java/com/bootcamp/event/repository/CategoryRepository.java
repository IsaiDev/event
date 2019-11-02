package com.bootcamp.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.event.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
