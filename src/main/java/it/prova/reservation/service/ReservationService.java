package it.prova.reservation.service;

import java.time.LocalDate;
import java.util.List;

import it.prova.reservation.model.Reservation;

public interface ReservationService {

	List<Reservation> findAll();

	Reservation findById(Long id);

	Reservation inserisciNuovo(Reservation input);

	Reservation aggiorna(Reservation input);

	void rimuovi(Long id);
	
	List<String> findUnavailableRooms (LocalDate dataDa, LocalDate dataA);
	
}
