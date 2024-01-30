package com.ruralHack.Repository;

import com.ruralHack.Domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,String> {

}
