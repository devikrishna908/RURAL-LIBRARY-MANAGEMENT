package com.luminar.librarymanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="members")
public class Members {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reg_no;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email_id")
    private String email;
    
    @Column(name = "membership_taken_on")
    private LocalDate membership_taken_on;
    
    @Column(name = "membership_due_on")
    private LocalDate membership_due_on;
    
    @Column(name="status")
    private String status;

	public Members() {
	}

	public Members(Integer reg_no, String name, String address, String phone, String email, LocalDate membership_taken_on,
			LocalDate membership_due_on,String status) {
		this.reg_no = reg_no;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.membership_taken_on = membership_taken_on;
		this.membership_due_on = membership_due_on;
		this.status = status;
	}

	public Integer getReg_no() {
		return reg_no;
	}

	public void setReg_no(Integer reg_no) {
		this.reg_no = reg_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getMembership_taken_on() {
		return membership_taken_on;
	}

	public void setMembership_taken_on(LocalDate membership_taken_on) {
		this.membership_taken_on = membership_taken_on;
	}

	public LocalDate getMembership_due_on() {
		return membership_due_on;
	}

	public void setMembership_due_on(LocalDate membership_due_on) {
		this.membership_due_on = membership_due_on;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}