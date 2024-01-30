package com.ruralHack.Controller.DTO;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GuestUpdate {

    private String firstName;
    private String lastName;
    @Email(message = "must be a valid format for email")
    private String email;

    public GuestUpdate(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
