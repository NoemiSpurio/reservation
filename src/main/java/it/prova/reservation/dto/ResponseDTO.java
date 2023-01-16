package it.prova.reservation.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {

	List<String> rooms = new ArrayList<>(0);

	public ResponseDTO() {
	}

	public ResponseDTO(List<String> rooms) {
		super();
		this.rooms = rooms;
	}

	public List<String> getRooms() {
		return rooms;
	}

	public void setRooms(List<String> rooms) {
		this.rooms = rooms;
	}

}
