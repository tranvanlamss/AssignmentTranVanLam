package com.example.assignmentspring.mapper;

import com.example.assignmentspring.dto.EmployeeDTO;
import com.example.assignmentspring.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeMapper {
    EmployeeEntity convertToEntity(EmployeeDTO employeeDTO);
    EmployeeDTO convertToDTO(EmployeeEntity employeeEntity);
}