package br.com.stoom.CRUD.services;

import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import br.com.stoom.CRUD.dto.AddressDTO;
import br.com.stoom.CRUD.enums.ErrorCodes;
import br.com.stoom.CRUD.exceptions.SystemRuntimeException;
import br.com.stoom.CRUD.services.interfaces.CallServices;

@Service
public class GoogleMapsCallService implements CallServices<AddressDTO> {

	@Override
	public AddressDTO execute(AddressDTO dto, Function<Map<String, Double>, AddressDTO> function) {
		
		try {
			
			GeoApiContext mapContext = new GeoApiContext.Builder()
				    .apiKey("AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw")
				    .build();
			
			GeocodingResult[] results = GeocodingApi.geocode(mapContext,dto.toString()).await();
			
			mapContext.shutdown();
		
			LatLng location = results[0].geometry.location;
			
			return function.apply(Map.of("latitude", location.lat,"longitude",location.lng));
			
		}catch(Exception e){
			throw new SystemRuntimeException(ErrorCodes.EXS0001);
		}
	}

}
