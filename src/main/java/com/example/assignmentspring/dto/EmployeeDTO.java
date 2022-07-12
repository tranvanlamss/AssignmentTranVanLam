package com.example.assignmentspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;
}
