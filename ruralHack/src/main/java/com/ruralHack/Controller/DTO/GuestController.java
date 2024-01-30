package com.ruralHack.Controller.DTO;

import com.ruralHack.Exception.AlreadyExistsException;
import com.ruralHack.Exception.isEmptyException;
import com.ruralHack.Service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {

    @Autowired
    GuestService guestService;

    @PostMapping("/guests")
    public ResponseEntity<String> addGuest(@Valid @RequestBody GuestInput guestInput){
        try {
            guestService.addGuest(guestInput);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
    }

    @GetMapping("/guests")
    public ResponseEntity<List<GuestOutput>> getAllGuests(){
        try {
            List<GuestOutput> guestsOutput = guestService.getAllGuests();
            return ResponseEntity.ok(guestsOutput);
        } catch (isEmptyException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    
}
