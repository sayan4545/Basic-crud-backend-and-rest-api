package com.devsayan.WebProject.controllers;

import com.devsayan.WebProject.dtos.EmployeeDTO;
import com.devsayan.WebProject.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    @GetMapping("/getAll")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAll();
    }
    @PostMapping("/post")
    public EmployeeDTO saveEmployeeDto(@RequestBody EmployeeDTO inputEmployeeDTO){
        return employeeService.createEmployee(inputEmployeeDTO);
    }
    @GetMapping("/getById/{id}")
    public Optional<EmployeeDTO> findByID(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }
    @PutMapping("/put/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO,
                                      @PathVariable Long id){
        return employeeService.updateEmployeeById(employeeDTO,id);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Long id){
        return employeeService.deleteById(id);
    }
    @PatchMapping("/patch/{id}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody
                                                 Map<String,Object> updates,
                                                 @PathVariable Long id){
        return employeeService.updatePartialEmployeeById(updates,id);
    }
}
