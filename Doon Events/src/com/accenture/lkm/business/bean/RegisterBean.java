package com.accenture.lkm.business.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterBean {

	@NotEmpty(message="Participant Name is mandatory")
	@Length(max=10, message="Participant Name can have maximum 10 characters")
	private String participantName;
	
	private String eventId;
	
	@NotNull(message="Participant Age is mandatory")
	@Min(value=1, message="Age must be greater than 0")
	private Integer age;
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}	
}