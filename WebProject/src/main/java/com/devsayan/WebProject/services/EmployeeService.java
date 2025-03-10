package com.devsayan.WebProject.services;

import com.devsayan.WebProject.dtos.EmployeeDTO;
import com.devsayan.WebProject.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
      public List<EmployeeDTO> getAll() ;
      public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
      public Optional<EmployeeDTO> findEmployeeById(Long id);
      public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long id);
      public boolean deleteById(Long id);


}
