package com.accenture.lkm.service;

public class InvalidAgeException extends Exception {

	public String getMessage()
	{
		return "Invalid Age";
	}
}