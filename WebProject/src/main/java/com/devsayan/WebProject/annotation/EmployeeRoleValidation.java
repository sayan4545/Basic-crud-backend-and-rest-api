package com.devsayan.WebProject.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = EmployeeRoleValidator.class)
public @interface EmployeeRoleValidation {

    String message() default "Role of the employee can be user or admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
