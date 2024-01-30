package com.ruralHack.Service;

import com.ruralHack.Controller.DTO.GuestInput;
import com.ruralHack.Controller.DTO.GuestOutput;
import com.ruralHack.Controller.DTO.GuestUpdate;
import com.ruralHack.Domain.Guest;
import com.ruralHack.Exception.AlreadyExistsException;
import com.ruralHack.Exception.IsEmptyException;
import com.ruralHack.Exception.NotExistsException;
import com.ruralHack.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<GuestOutput> getAllGuests() throws IsEmptyException {
        List<Guest> guests = guestRepository.findAll();
        if(guests.isEmpty()) throw new IsEmptyException("List of guests is empty");
        List<GuestOutput> guestsOutput = new ArrayList<>();

        for(Guest guest: guests){
            guestsOutput.add(GuestOutput.getGuest(guest));
        }
        return guestsOutput;
    }

    public void deleteGuest(String id) throws NotExistsException {
        if(!guestRepository.existsById(id)) throw new NotExistsException("Guest doesn't exist");
        guestRepository.deleteById(id);
    }

    public void updateGuest(String id, GuestUpdate guestUpdate) throws NotExistsException {
        if(!guestRepository.existsById(id)) throw new NotExistsException("Guest doesn´t exist");
        Optional<Guest> guest = guestRepository.findById(id);
        Guest guestSet = guest.get();
        guestSet.setFirstName(guestUpdate.getFirstName());
        guestSet.setLastName(guestUpdate.getLastName());
        guestSet.setEmail(guestUpdate.getEmail());
        guestRepository.save(guestSet);
    }
}
