package com.example.week02_day05_e_rahafalammar;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class Employees {
    @NotNull
    @Min(3)
    private Integer ID;
    @NotBlank
    @Size(min = 5, message = "The name most be more than 4")
    private String name;
    @NotNull
    @Range(min = 25, message = "The age most be grater than 25")
    private Integer age;
    @AssertFalse(message = "You have to enter false in onLeave")
    private Boolean onLeave;
    @Range(min = 2000 , max = 2022 , message = "The year most be from 2000 - 2022")
    private Integer employmentYear;
    @NotBlank
    @Pattern(regexp = "[0-9]+", message = "invalid annualLeave")
    private String annualLeave;
}
