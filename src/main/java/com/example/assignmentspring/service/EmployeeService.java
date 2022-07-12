package com.example.assignmentspring.service;

import com.example.assignmentspring.dto.EmployeeDTO;
import com.example.assignmentspring.entity.EmployeeEntity;
import com.example.assignmentspring.entity.UserEntity;
import com.example.assignmentspring.mapper.EmployeeMapper;
import com.example.assignmentspring.repository.EmployeeRepository;
import com.example.assignmentspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    UserRepository userRepository;

    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntityConvert = employeeMapper.convertToEntity(employeeDTO);
        EmployeeEntity employeeEntity = employeeRepository.save(employeeEntityConvert);
        EmployeeDTO dto = employeeMapper.convertToDTO(employeeEntity);
        return dto;
    }


    public void deleteEmployee(int id) {

    }


    public void deleteAllEmployee(EmployeeDTO employeeDTO) {

    }


    public EmployeeDTO getEmployeeById(int id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("not found");
        }
        SimpleGrantedAuthority grand = new SimpleGrantedAuthority(userEntity.getRole().getName());
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(grand);
        User user = new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
        return user;
    }
}

