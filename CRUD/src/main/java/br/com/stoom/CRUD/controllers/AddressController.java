package br.com.stoom.CRUD.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.stoom.CRUD.dto.AddressDTO;
import br.com.stoom.CRUD.dto.AddressDTO.BuilderAddressDTO;
import br.com.stoom.CRUD.enums.ClientMessagens;
import br.com.stoom.CRUD.models.Address;
import br.com.stoom.CRUD.services.interfaces.Services;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
	
	@Autowired
	Services<AddressDTO,Address> addressService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String createAddress() {
		try {
			
			final List<Address> listAddress = this.addressService.executeReadAll();
			
			return new Gson().toJson(listAddress);
			
		}catch (Exception e) {
			return ClientMessagens.ERROR.ErrorClient(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/", consumes = "application/JSON", method = RequestMethod.POST)
	public String createAddress(@RequestBody Map<String,?> request ) {
		
		final AddressDTO addressDTO = BuilderAddressDTO.create()
				.setCity(String.valueOf(request.get("city")))
				.setState(String.valueOf(request.get("state")))
				.setComplement(String.valueOf(request.get("complement")))
				.setCountry(String.valueOf(request.get("country")))
				.setNeighbourhood(String.valueOf(request.get("neighbourhood")))
				.setNumber(String.valueOf(request.get("number")))
				.setStreetName(String.valueOf(request.get("streetName")))
				.setZipcode(String.valueOf(request.get("zipcode")))
				.setLatitude(String.valueOf(request.get("latitude")))
				.setLongitude(String.valueOf(request.get("longitude")))
				.build();
		try {
			this.addressService.executeCreate(addressDTO);
			return ClientMessagens.CREATED.SuccessClient("");
		}catch (Exception e) {
			return ClientMessagens.ERROR.ErrorClient(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/delete&id", method = RequestMethod.DELETE)
	public String createAddress(@RequestParam String id ) {
		
		final AddressDTO addressDTO = BuilderAddressDTO.create()
				.setId(String.valueOf(id))
				.build();
		try {
			this.addressService.executeCreate(addressDTO);
			return ClientMessagens.DELETED.SuccessClient("");
		}catch (Exception e) {
			return ClientMessagens.ERROR.ErrorClient(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/update", consumes = "application/JSON", method = RequestMethod.PATCH)
	public String updateAddress(@RequestBody Map<String,?> request ) {
		
		final AddressDTO addressDTO = BuilderAddressDTO.create()
				.setId(String.valueOf(request.get("id")))
				.setCity(String.valueOf(request.get("city")))
				.setState(String.valueOf(request.get("state")))
				.setComplement(String.valueOf(request.get("complement")))
				.setCountry(String.valueOf(request.get("country")))
				.setNeighbourhood(String.valueOf(request.get("neighbourhood")))
				.setNumber(String.valueOf(request.get("number")))
				.setStreetName(String.valueOf(request.get("streetName")))
				.setZipcode(String.valueOf(request.get("zipcode")))
				.setLatitude(String.valueOf(request.get("latitude")))
				.setLongitude(String.valueOf(request.get("longitude")))
				.build();
		try {
			this.addressService.executeUpdate(addressDTO);
			return ClientMessagens.UPDATED.SuccessClient("");
		}catch (Exception e) {
			return ClientMessagens.ERROR.ErrorClient(e.getMessage());
		}
	}

}
