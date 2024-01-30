package com.ruralHack.Service;

import com.ruralHack.Controller.DTO.GuestInput;
import com.ruralHack.Controller.DTO.GuestOutput;
import com.ruralHack.Domain.Guest;
import com.ruralHack.Exception.AlreadyExistsException;
import com.ruralHack.Exception.isEmptyException;
import com.ruralHack.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<GuestOutput> getAllGuests() throws isEmptyException {
        List<Guest> guests = guestRepository.findAll();
        if(guests.isEmpty()) throw new isEmptyException("List of guests is empty");
        List<GuestOutput> guestsOutput = new ArrayList<>();

        for(Guest guest: guests){
            guestsOutput.add(GuestOutput.getGuest(guest));
        }
        return guestsOutput;
    }


}
