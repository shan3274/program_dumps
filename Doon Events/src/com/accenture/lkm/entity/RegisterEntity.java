package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Register_Details")
public class RegisterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RegistrationId")
	private Integer registrationId;
	
	@Column(name="ParticipantName")
	private String participantName;
	
	@Column(name="EventId")
	private String eventId;
	
	public Integer getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}	
}