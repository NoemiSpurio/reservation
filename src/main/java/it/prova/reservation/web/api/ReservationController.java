package it.prova.reservation.web.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import it.prova.reservation.dto.FormDTO;
import it.prova.reservation.dto.ResponseDTO;
import it.prova.reservation.model.Reservation;
import it.prova.reservation.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@Autowired
	private WebClient webClient;

	private static final Logger LOGGER = LogManager.getLogger(ReservationController.class);
	
	@GetMapping
	public List<Reservation> listAll() {
		return this.service.findAll();
	}
	
	@PostMapping
	public List<String> findAvailableRoom(@RequestBody FormDTO dateDTO){
		
		List<String> unavailableRooms = service.findUnavailableRooms(dateDTO.getDataDa(), dateDTO.getDataA());
		
		LOGGER.info("....invocazione servizio esterno....");
		
		ResponseDTO allRooms = webClient.get().uri("").retrieve().bodyToMono(ResponseDTO.class).block();
		
		LOGGER.info("....invocazione servizio esterno terminata....");
		
		allRooms.getRooms().removeAll(unavailableRooms);
		
		return allRooms.getRooms();
	}
}
