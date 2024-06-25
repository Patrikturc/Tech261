package com.sparta.pt.DTO;

import java.time.LocalDate;

public record EmployeeDTO(String name, Integer salary, LocalDate DOB) {

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", DOB=" + DOB +
                '}';
    }

}
