package com.agilent.dbSolution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agilent.dbSolution.entities.Part;

public interface PartRepository extends JpaRepository<Part, Long> {

}
