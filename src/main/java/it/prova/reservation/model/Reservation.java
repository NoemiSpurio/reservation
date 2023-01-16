package it.prova.reservation.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "datada")
	private LocalDate dataDa;

	@Column(name = "dataa")
	private LocalDate dataA;

	@Column(name = "room")
	private String room;

	public Reservation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDa() {
		return dataDa;
	}

	public void setDataDa(LocalDate dataDa) {
		this.dataDa = dataDa;
	}

	public LocalDate getDataA() {
		return dataA;
	}

	public void setDataA(LocalDate dataA) {
		this.dataA = dataA;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}
