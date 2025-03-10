package com.devsayan.WebProject.services;

import com.devsayan.WebProject.dtos.EmployeeDTO;
import com.devsayan.WebProject.entities.EmployeeEntity;
import com.devsayan.WebProject.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }

    @Override
    public Optional<EmployeeDTO> findEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        return modelMapper.map(employee, Optional.class);
    }

    @Override
    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        employeeDTO.setId(id);
        modelMapper.map(employeeDTO,employeeEntity);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee,EmployeeDTO.class);
    }

    @Override
    public boolean deleteById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if(employeeEntity!=null){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
