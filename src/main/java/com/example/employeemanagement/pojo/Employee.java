package com.example.employeemanagement.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank(message = "First name cannot be blank")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Past(message = "Must be a past date")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NonNull
    @Column(name = "age", nullable = false)
    private Date dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @NonNull
    @Column(name = "start_date", nullable = false)
    private Date startDate;

}
