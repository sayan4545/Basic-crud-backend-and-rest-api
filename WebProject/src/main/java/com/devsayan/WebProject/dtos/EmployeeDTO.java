package com.devsayan.WebProject.dtos;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Cannot be blank")
    @Size(min = 3, max = 15,message = "range is between 3 and 10")
    private String name;

    @Max(value = 80,message = "cant be greater than 80")
    private int age;
    private LocalDate doj;
    private boolean isActive;
}
