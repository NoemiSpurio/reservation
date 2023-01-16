package it.prova.reservation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.reservation.model.Reservation;
import it.prova.reservation.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> findAll() {
		return (List<Reservation>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Reservation findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Reservation inserisciNuovo(Reservation input) {
		if (input.getId() != null) {
			throw new RuntimeException("Non puoi inserire una prenotazione con un id associato.");
		}

		return repository.save(input);
	}

	@Override
	public Reservation aggiorna(Reservation input) {
		return repository.save(input);
	}

	@Override
	public void rimuovi(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<String> findUnavailableRooms(LocalDate dataDa, LocalDate dataA) {
		return repository.findAllUnavailableRoom(dataDa, dataA);
	}

}
