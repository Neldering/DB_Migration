package com.agilent.dbSolution.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.agilent.dbSolution.entities.InspectionTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metaPart")
public class MetaPart {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	private String description;
	
	private String failCondition;
	
	
	@Nullable
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Tests_To_Run_Meta")
	private Set<InspectionTest> tests;
	
	
	

	@Override
	public String toString() {
		return "MetaPart [id=" + id + ", name=" + name + ", description=" + description + ", failCondition="
				+ failCondition + ", tests=" + tests + "]";
	}

	public String getFailCondition() {
		return failCondition;
	}

	public void setFailCondition(String failCondition) {
		this.failCondition = failCondition;
	}

	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<InspectionTest> getTests() {
		return tests;
	}

	public void setTests(Set<InspectionTest> tests) {
		this.tests = tests;
	}

	
}
