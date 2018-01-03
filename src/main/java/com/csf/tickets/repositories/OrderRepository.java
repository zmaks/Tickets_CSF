package com.csf.tickets.repositories;

import com.csf.tickets.entities.TicketOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<TicketOrder, Long> {
    List<TicketOrder> findByUserId(String userId);
}
