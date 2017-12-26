package com.csf.tickets.repositories;

import com.csf.tickets.entities.Order;
import com.csf.tickets.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserId(String userId);
}
