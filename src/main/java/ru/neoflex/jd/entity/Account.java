package ru.neoflex.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private UUID id;
    private UUID bankId;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate dateOfBirth;
    private String passportNumber;
    private String birthPlace;
    private String phoneNumber;
    private String email;
    private String registrationAddress;
    private String residenceAddress;
}
