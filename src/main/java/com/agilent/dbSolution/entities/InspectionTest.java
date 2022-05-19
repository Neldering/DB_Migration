package com.agilent.dbSolution.entities;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.agilent.dbSolution.utilities.StringListConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inspectionTest")
public class InspectionTest {


	@Id
	@GeneratedValue
	private Long id;

	private String name;
	 
	private String description;
	
	private String steps;
	
	@Convert(converter = StringListConverter.class)
	private List<String> onFail;

	@Convert(converter = StringListConverter.class)
	private List<String> requiredTools;

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

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public List<String> getOnFail() {
		return onFail;
	}

	public void setOnFail(List<String> onFail) {
		this.onFail = onFail;
	}

	public List<String> getRequiredTools() {
		return requiredTools;
	}

	public void setRequiredTools(List<String> requiredTools) {
		this.requiredTools = requiredTools;
	}

	

	@Override
	public String toString() {
		return "InspectionTest [id=" + id + ", name=" + name + ", description=" + description + ", steps=" + steps
				+ ", onFail=" + onFail + ", requiredTools=" + requiredTools + "]";
	}
	
}
