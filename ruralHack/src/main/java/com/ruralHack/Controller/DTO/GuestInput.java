package com.ruralHack.Controller.DTO;

import com.ruralHack.Domain.Guest;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GuestInput {

    @NotNull(message = "firstName is null")
    @NotEmpty(message = "firstName is null")
    private String firstName;
    @NotNull(message = "lastName is null")
    @NotEmpty(message = "lastName is null")
    private String lastName;
    @NotNull(message = "email is null")
    @NotEmpty(message = "email is null")
    @Email(message = "must be a valid format for email")
    private String email;
    @Past(message = "must be a past date")
    private LocalDate birthDate;

    public GuestInput(String firstName, String lastName, String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public static Guest getGuest(GuestInput guestInput) {
        return new Guest(guestInput.getFirstName(), guestInput.getLastName(), guestInput.getEmail(),
                guestInput.getBirthDate());
    }
}
