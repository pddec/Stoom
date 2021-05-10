package br.com.stoom.CRUD.enums;


public enum ErrorCodes {
	
	//External Services ERROR
	EXS0001, // Google Map API
	
	//DATA BASE ERRORS
	DBE0001,// Error to readAll
	DBE0002,// Error to delete
	DBE0003,// Error to update
	DBE0004,// Error to create
	DBE0005,// Error to read as pages
	
	//INTERNAL SYSTEM ERROR
	
	ISE0001; // NOT MAPPED KEY  
	
	
}
