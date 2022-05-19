package com.agilent.dbSolution.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agilent.dbSolution.entities.Part;
import com.agilent.dbSolution.repo.PartRepository;

@RestController
@RequestMapping("/parts")
public class PartController {

	private final PartRepository partRepository;
	
	public PartController(PartRepository partRepository) {
		this.partRepository=partRepository;
	}
	
	@GetMapping("/{id}")
	public Part getPart(@PathVariable Long id) {
		return partRepository.findById(id).orElseThrow(RuntimeException::new);
		
	}
	
	@PostMapping
	public ResponseEntity createPart(@RequestBody Part part) throws URISyntaxException{
		Part savedPart = partRepository.save(part);
		return ResponseEntity.created(new URI("/parts/" + savedPart.getPartId())).body(savedPart);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updatePart(@PathVariable Long id, @RequestBody Part part) {
		Part currentPart = partRepository.findById(id).orElseThrow(RuntimeException::new);
		currentPart.setName(part.getName());
		currentPart.setTesters(part.getTesters());
		currentPart.setTestIds(part.getTestIds());
		currentPart.setLastTestFailed(part.getLastTestFailed());
		currentPart.setMetaPartID(part.getMetaPartID());
		currentPart.setTestsPassed(part.getTestsPassed());
		currentPart.setStatus(part.getStatus());
		currentPart.setCheckedIn(part.getCheckedIn());
		currentPart.setCheckedInLastBy(part.getCheckedInLastBy());
		currentPart.setCheckedOut(part.getCheckedOut());
		currentPart.setCheckedOutLastBy(part.getCheckedOutLastBy());
		
		return ResponseEntity.ok(currentPart);
		
	}
	
	//todo
	// checkin part
	// check out part 
	// set status to fail

	
	@DeleteMapping("/{id}")
    public ResponseEntity deletePart(@PathVariable Long id) {
        partRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
	
	

