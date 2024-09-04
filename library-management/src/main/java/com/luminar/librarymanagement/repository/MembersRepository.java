package com.luminar.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luminar.librarymanagement.entity.Members;

public interface MembersRepository extends JpaRepository<Members, Integer>{

}
