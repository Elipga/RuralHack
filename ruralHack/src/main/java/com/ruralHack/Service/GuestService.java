package com.ruralHack.Service;

import com.ruralHack.Controller.DTO.GuestInput;
import com.ruralHack.Domain.Guest;
import com.ruralHack.Exception.AlreadyExistsException;
import com.ruralHack.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    @Autowired
    GuestRepository guestRepository;

    public void addGuest(GuestInput guestInput) throws AlreadyExistsException {
        Guest newGuest = GuestInput.getGuest(guestInput);
        if(guestRepository.existsById(guestInput.getEmail())) throw new AlreadyExistsException("Guest already" +
                "exists");
        guestRepository.save(newGuest);

    }
}
