package com.csf.tickets.repositories;

import com.csf.tickets.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByUserId(String userId);
    List<Reservation> findByReserveTimeBeforeAndStatus(Date beforeDate, String status);
}
