package com.ruralHack.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "guests")
@Getter
@Setter
@NoArgsConstructor
public class Guest {

    @NotNull(message = "Id is null")
    @NotEmpty(message = "Id is null")
    @Id
    private String id;
    @NotNull(message = "firstName is null")
    @NotEmpty(message = "firstName is null")
    private String firstName;
    @NotNull(message = "lastName is null")
    @NotEmpty(message = "lastName is null")
    private String lastName;
    @NotNull(message = "email is null")
    @NotEmpty(message = "email is null")
    @Email (message = "must be a valid format for email")
    private String email;
    @Past (message = "must be a past date")
    private LocalDate birthDate;

    public Guest(String id, String firstName, String lastName, String email, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }
}
