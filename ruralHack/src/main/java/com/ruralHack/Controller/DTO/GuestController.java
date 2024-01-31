package com.ruralHack.Controller.DTO;

import com.ruralHack.Exception.AlreadyExistsException;
import com.ruralHack.Exception.IsEmptyException;
import com.ruralHack.Exception.NotExistsException;
import com.ruralHack.Service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
        } catch (IsEmptyException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/guests/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable String id){
        try {
            guestService.deleteGuest(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/guests/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable String id, @Valid @RequestBody GuestUpdate guestUpdate){
        try {
            guestService.updateGuest(id, guestUpdate);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NotExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
