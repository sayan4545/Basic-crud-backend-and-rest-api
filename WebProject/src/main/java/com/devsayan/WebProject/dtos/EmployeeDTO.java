package com.devsayan.WebProject.dtos;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter

public class EmployeeDTO {
    private Long id;
    private String name;
    private int age;
    private LocalDate doj;
    private boolean isActive;
}
