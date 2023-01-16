package it.prova.reservation.dto;

import java.time.LocalDate;

public class FormDTO {

	private LocalDate dataDa;
	private LocalDate dataA;

	public FormDTO() {
	}

	public FormDTO(LocalDate dataDa, LocalDate dataA) {
		super();
		this.dataDa = dataDa;
		this.dataA = dataA;
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

}
