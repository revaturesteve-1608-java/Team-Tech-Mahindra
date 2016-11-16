package com.tm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tm.model.Ticket;

@RepositoryRestResource
public interface TicketRepo extends JpaRepository<Ticket, Long>{

}
