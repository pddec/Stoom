package br.com.stoom.CRUD.services.interfaces;

import java.util.Map;
import java.util.function.Function;

public interface CallServices<T> {
	
	T execute(T dto, Function<Map<String, Double>,T> function);

}
