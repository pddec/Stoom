package br.com.stoom.CRUD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.stoom.CRUD.dto.AddressDTO;
import br.com.stoom.CRUD.dto.AddressDTO.BuilderAddressDTO;
import br.com.stoom.CRUD.enums.ErrorCodes;
import br.com.stoom.CRUD.exceptions.SystemRuntimeException;
import br.com.stoom.CRUD.models.Address;
import br.com.stoom.CRUD.repositories.AddressRepository;
import br.com.stoom.CRUD.services.interfaces.CallServices;
import br.com.stoom.CRUD.services.interfaces.Services;

@Service
public class AddressService implements Services<AddressDTO,Address> {
	
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CallServices<AddressDTO> googleMapCallService;
	
	@Override
	public List<Address> executeReadAll() {
		
		try {	
			final Iterable<Address> addresses = this.addressRepository.findAll();
			return Lists.newArrayList(addresses);
		}catch(Exception e) {
			throw new SystemRuntimeException(ErrorCodes.DBE0001);
		}
	}

	@Override
	public Address executeCreate(AddressDTO dto) {
		
		if(dto.getLatitude() == null && dto.getLongitude() == null) {
			
			dto = this.callServiceGoogleMapMethod(dto);
		}
		
		final Address addressModel = new Address(dto);
		
		try {
			return this.addressRepository.save(addressModel);
		}catch(Exception e) {
			throw new SystemRuntimeException(ErrorCodes.DBE0004);
		}
		
	}

	@Override
	public Address executeUpdate(AddressDTO dto) {
		
		dto = this.callServiceGoogleMapMethod(dto);
		
		final Address addressModel = new Address(dto);
		
		try {
			return this.addressRepository.save(addressModel);
		}catch(Exception e) {
			throw new SystemRuntimeException(ErrorCodes.DBE0003);
		}
	}
	
	@Override
	public boolean executeDelete(AddressDTO dto) {
		try {
			
			this.addressRepository.deleteById(dto.getId());
			
			return !this.addressRepository.existsById(dto.getId());
		
		}catch(Exception e) {
			throw new SystemRuntimeException(ErrorCodes.DBE0002);
		}
	}
	
	private AddressDTO callServiceGoogleMapMethod(final AddressDTO dto) {
		return this.googleMapCallService.execute(dto, response ->
			BuilderAddressDTO.create()
				.setId(dto.getId())
				.setCity(dto.getCity())
				.setComplement(dto.getComplement())
				.setCountry(dto.getCountry())
				.setNeighbourhood(dto.getNeighbourhood())
				.setNumber(dto.getNumber())
				.setStreetName(dto.getStreetName())
				.setState(dto.getState())
				.setZipcode(dto.getZipcode())
				.setLatitude(response.get("latitude"))
				.setLongitude(response.get("longitude"))
				.build());
	}
		
}
