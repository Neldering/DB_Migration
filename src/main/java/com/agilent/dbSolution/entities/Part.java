package com.agilent.dbSolution.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "part")
public class Part {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToMany
	@JoinTable
	private Set<Employee> testers;

	@ManyToMany
	@JoinTable
	private Set<InspectionTest> testIds;

	private Long metaPartID;
	
	@ManyToMany
	@JoinTable
	private Set<InspectionTest> testsPassed;
	
	private Date checkedIn;

	private String status;

	
	@Nullable
	private Date checkedOut;
	
	@Nullable
	private String checkedOutLastBy;
	
	private String checkedInLastBy;
	

	@Nullable
	private Long lastTestFailed;


	public Long getPartId() {
		return id;
	}


	public void setPartId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Employee> getTesters() {
		return testers;
	}


	public void setTesters(Set<Employee> testers) {
		this.testers = testers;
	}


	public Set<InspectionTest> getTestIds() {
		return testIds;
	}


	public void setTestIds(Set<InspectionTest> testIds) {
		this.testIds = testIds;
	}


	public Long getMetaPartID() {
		return metaPartID;
	}


	public void setMetaPartID(Long metaPartID) {
		this.metaPartID = metaPartID;
	}


	public Set<InspectionTest> getTestsPassed() {
		return testsPassed;
	}


	public void setTestsPassed(Set<InspectionTest> testsPassed) {
		this.testsPassed = testsPassed;
	}


	public Date getCheckedIn() {
		return checkedIn;
	}


	public void setCheckedIn(Date checkedIn) {
		this.checkedIn = checkedIn;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCheckedOut() {
		return checkedOut;
	}


	public void setCheckedOut(Date checkedOut) {
		this.checkedOut = checkedOut;
	}


	public String getCheckedOutLastBy() {
		return checkedOutLastBy;
	}


	public void setCheckedOutLastBy(String checkedOutLastBy) {
		this.checkedOutLastBy = checkedOutLastBy;
	}


	public String getCheckedInLastBy() {
		return checkedInLastBy;
	}


	public void setCheckedInLastBy(String checkedInLastBy) {
		this.checkedInLastBy = checkedInLastBy;
	}


	public Long getLastTestFailed() {
		return lastTestFailed;
	}


	public void setLastTestFailed(Long lastTestFailed) {
		this.lastTestFailed = lastTestFailed;
	}




	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", testers=" + testers + ", testIds=" + testIds + ", metaPartID="
				+ metaPartID + ", testsPassed=" + testsPassed + ", checkedIn=" + checkedIn + ", status=" + status
				+ ", checkedOut=" + checkedOut + ", checkedOutLastBy=" + checkedOutLastBy + ", checkedInLastBy="
				+ checkedInLastBy + ", lastTestFailed=" + lastTestFailed + "]";
	}



}
