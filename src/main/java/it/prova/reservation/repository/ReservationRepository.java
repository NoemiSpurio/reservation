package it.prova.reservation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.reservation.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	
	@Query(value = "select r.room from reservation r where ?2 < r.datada and ?1 > r.dataa", nativeQuery = true)
	List<String> findAllUnavailableRoom(LocalDate inputDataDa, LocalDate inputDataA);

}
