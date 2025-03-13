package com.devsayan.WebProject.controllers;

import com.devsayan.WebProject.dtos.EmployeeDTO;
import com.devsayan.WebProject.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatusCode.valueOf(200));
    }
    @PostMapping("/post")
    public ResponseEntity<EmployeeDTO> saveEmployeeDto(@RequestBody EmployeeDTO inputEmployeeDTO){
        employeeService.createEmployee(inputEmployeeDTO);
        return new ResponseEntity<>(inputEmployeeDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeDTO> findByID(@PathVariable Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.findEmployeeById(id);
        return employeeDTO.
                map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound()
                        .build());
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO,
                                      @PathVariable Long id){
        employeeService.updateEmployeeById(employeeDTO,id);
        return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
    }
//    @DeleteMapping("/delete/{id}")
//    public boolean deleteById(@PathVariable Long id){
//        return employeeService.deleteById(id);
//
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean isDeleted = employeeService.deleteById(id);
        if (isDeleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody
                                                 Map<String,Object> updates,
                                                 @PathVariable Long id){
        EmployeeDTO updatedEmployee = employeeService.updatePartialEmployeeById(updates,id);
        return ResponseEntity.ok(updatedEmployee);
    }
}
