package com.tm.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.model.Ticket;
import com.tm.repos.TicketRepo;

@Component
public class SampleDataInit implements CommandLineRunner{

	private final TicketRepo ticketRepo;
	
	@Autowired
	public SampleDataInit(TicketRepo ticketRepo) {
		this.ticketRepo = ticketRepo;
	}

	@Override
	public void run(String... arg0) throws Exception {
		ticketRepo.save(new Ticket("Craig", "Allen", "555-5555", "example@revature.com", 4102L, 35L));
		ticketRepo.save(new Ticket("Dexter", "Hu", "555-5555", "example@revature.com", 4102L, 32L));
		ticketRepo.save(new Ticket("Johnathan", "Cox", "555-5555", "example@revature.com", 4102L, 71L));
		ticketRepo.save(new Ticket("Cheng", "Ma", "555-5555", "example@revature.com", 873L, 16L));
		ticketRepo.save(new Ticket("Johnathan", "Morales", "555-5555", "example@revature.com", 873L, 17L));
	}
	
	
	
}
