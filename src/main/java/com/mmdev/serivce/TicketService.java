package com.mmdev.serivce;

import com.mmdev.dao.TicketDao;
import com.mmdev.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

	public static final TicketService INSTANCE = new TicketService();
	public static TicketDao ticketDao = TicketDao.getInstance();

	private TicketService() {
	}

	public List<TicketDto> findAllFlightsById(Long id) {
		return ticketDao.findAllFlightsById(id).stream()
				.map(ticket -> new TicketDto(
						ticket.getId(),
						"""
									%s - %s - %s
								""".formatted(ticket.getId(), ticket.getFlightId(), ticket.getPassengerNo())))
				.collect(toList());
	}

	public static TicketService getInstance() {
		return INSTANCE;
	}
}