package com.devsayan.WebProject.dtos;

import com.devsayan.WebProject.annotation.EmployeeRoleValidation;
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
    //@Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    @NotBlank(message = "Role cannot be blank")
    private String role;//Admin and USer

    @PastOrPresent(message = "The date of joining can be a date of past, or the present date")
    private LocalDate doj;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary is always positive")
    @Digits(integer = 7,fraction = 3)
    private Double salary;
    private boolean isActive;
}
