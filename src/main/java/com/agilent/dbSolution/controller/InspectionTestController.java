package com.agilent.dbSolution.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agilent.dbSolution.repo.InspectionTestRepository;
import com.agilent.dbSolution.entities.InspectionTest;

@RestController
@RequestMapping("/inspectionTests")
public class InspectionTestController {

    private final InspectionTestRepository inspectionTestRepository;

    public InspectionTestController(InspectionTestRepository inspectionTestRepository) {
        this.inspectionTestRepository = inspectionTestRepository;
    }

    @GetMapping
    public List<InspectionTest> getInspectionTests() {
        return inspectionTestRepository.findAll();
    }

    @GetMapping("/{id}")
    public InspectionTest getInspectionTest(@PathVariable Long id) {
        return inspectionTestRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createInspectionTest(@RequestBody InspectionTest inspectionTest) throws URISyntaxException {
        InspectionTest savedInspectionTest = inspectionTestRepository.save(inspectionTest);
        return ResponseEntity.created(new URI("/inspectionTests/" + savedInspectionTest.getId())).body(savedInspectionTest);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateInspectionTest(@PathVariable Long id, @RequestBody InspectionTest inspectionTest) {
        InspectionTest currentInspectionTest = inspectionTestRepository.findById(id).orElseThrow(RuntimeException::new);
        currentInspectionTest.setName(inspectionTest.getName());
        currentInspectionTest.setDescription(inspectionTest.getDescription());
        currentInspectionTest.setOnFail(inspectionTest.getOnFail());
        currentInspectionTest.setRequiredTools(inspectionTest.getRequiredTools());
        currentInspectionTest.setSteps(inspectionTest.getSteps());
        currentInspectionTest = inspectionTestRepository.save(inspectionTest);

        return ResponseEntity.ok(currentInspectionTest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteInspectionTest(@PathVariable Long id) {
    	inspectionTestRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}