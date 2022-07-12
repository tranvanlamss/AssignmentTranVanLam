package com.example.assignmentspring.repository;

import com.example.assignmentspring.entity.EmployeeEntity;
import com.example.assignmentspring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
