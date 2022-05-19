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

import com.agilent.dbSolution.entities.MetaPart;
import com.agilent.dbSolution.repo.MetaPartRepository;

@RestController
@RequestMapping("/MetaParts")
public class MetaPartController {

		private final MetaPartRepository metaPartRepository;
		
		public MetaPartController(MetaPartRepository metaPartRepository) {
			this.metaPartRepository = metaPartRepository;
			
		}

		@GetMapping
	    public List<MetaPart> getMetaParts() {
	        return metaPartRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public MetaPart getMetaPart(@PathVariable Long id) {
	        return metaPartRepository.findById(id).orElseThrow(RuntimeException::new);
	    }
	    
	    @PostMapping
	    public ResponseEntity createMetaPart(@RequestBody MetaPart metaPart) throws URISyntaxException {
	        MetaPart savedMetaPart = metaPartRepository.save(metaPart);
	        return ResponseEntity.created(new URI("/metaParts/" + savedMetaPart.getId())).body(savedMetaPart);
	    }
		
	    @PutMapping("/{id}")
	    public ResponseEntity updateMetaPart(@PathVariable Long id, @RequestBody MetaPart metaPart) {
	        MetaPart currentMetaPart = metaPartRepository.findById(id).orElseThrow(RuntimeException::new);
	        currentMetaPart.setName(metaPart.getName());
	        currentMetaPart.setFailCondition(metaPart.getFailCondition());
	        currentMetaPart.setName(metaPart.getName());
	        currentMetaPart.setDescription(metaPart.getDescription());

	        currentMetaPart = metaPartRepository.save(metaPart);

	        return ResponseEntity.ok(currentMetaPart);
	    }
	    
		
	    @PutMapping("/AddTestsToMetaPart/{id}")
	    public ResponseEntity updateMetaPartInspectionTests(@PathVariable Long id, @RequestBody MetaPart metaPart) {
	        MetaPart currentMetaPart = metaPartRepository.findById(id).orElseThrow(RuntimeException::new);
	      ;
	        currentMetaPart.setTests(metaPart.getTests());

	        currentMetaPart = metaPartRepository.save(metaPart);

	        return ResponseEntity.ok(currentMetaPart);
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity deleteMetaPart(@PathVariable Long id) {
	        metaPartRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	    
}


