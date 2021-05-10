package br.com.stoom.CRUD.services.interfaces;

import java.util.List;

public interface Services<T,D> {
	
	D executeCreate(T dto);
	
	List<D> executeReadAll();
	
	D executeUpdate(T dto);
	
	boolean executeDelete(T dto);

}