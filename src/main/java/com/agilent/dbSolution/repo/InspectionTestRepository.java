package com.agilent.dbSolution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agilent.dbSolution.entities.InspectionTest;

public interface InspectionTestRepository extends JpaRepository<InspectionTest, Long> {

}
