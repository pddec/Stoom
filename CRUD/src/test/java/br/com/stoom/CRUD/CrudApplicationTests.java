package br.com.stoom.CRUD;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.stoom.CRUD.dto.AddressDTO;
import br.com.stoom.CRUD.dto.AddressDTO.BuilderAddressDTO;
import br.com.stoom.CRUD.models.Address;
import br.com.stoom.CRUD.services.interfaces.Services;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ActiveProfiles("test")
class CrudApplicationTests {
	 
	@Autowired
	private Services<AddressDTO,Address> addressService;
	
	private AddressDTO addressDTO;

	private static Long id;
	
	@BeforeEach
	public void createContext() {
		this.addressDTO = BuilderAddressDTO.create()
				.setCity("Campinas")
				.setState("São Paulo")
				.setComplement("0")
				.setCountry("Brasil")
				.setNeighbourhood("Jardim Guarani")
				.setNumber("11")
				.setStreetName("Av. Imperatriz Dona Tereza Cristina")
				.setZipcode("13100200")
				.setLatitude("")
				.setLongitude("")
				.build();
	}
	
	@Test
	public void testCreate() {
		
		final Address address = addressService.executeCreate(this.addressDTO);
		
		CrudApplicationTests.id = address.getId();
	
		assertEquals(this.addressDTO.getCity(), address.getCity());
		assertEquals(this.addressDTO.getComplement(), address.getComplement());
		assertEquals(this.addressDTO.getCountry(), address.getCountry());
		assertEquals(this.addressDTO.getNeighbourhood(), address.getNeighbourhood());
		assertEquals(this.addressDTO.getNumber(), address.getNumber());
		assertEquals(this.addressDTO.getState(), address.getState());
		assertEquals(this.addressDTO.getStreetName(), address.getStreetName());
		assertEquals(-22.9108864 , address.getLatitude());
		assertEquals(-47.0433847, address.getLongitude());
		assertEquals(this.addressDTO.getZipcode(), address.getZipcode());
	}
	
	@Test
	public void testUpdate() {
		
		final AddressDTO updateAddressDTO = BuilderAddressDTO.create()
				.setId(CrudApplicationTests.id)
				.setCity("Campinas")
				.setState("São Paulo")
				.setComplement("616")
				.setCountry("Brasil")
				.setNeighbourhood("Centro")
				.setNumber("233")
				.setStreetName("Rua Conceição")
				.setZipcode("13010916")
				.setLatitude("")
				.setLongitude("")
				.build();
		
		this.addressService.executeCreate(this.addressDTO);
		final Address address = this.addressService.executeUpdate(updateAddressDTO);
		
		assertEquals(updateAddressDTO.getCity(), address.getCity());
		assertEquals(updateAddressDTO.getCountry(), address.getCountry());
		assertEquals(updateAddressDTO.getState(), address.getState());
		
		assertEquals(updateAddressDTO.getCity(), this.addressDTO.getCity());
		assertEquals(updateAddressDTO.getCountry(), this.addressDTO.getCountry());
		assertEquals(updateAddressDTO.getState(), this.addressDTO.getState());
		
		assertEquals(this.addressDTO.getCity(), address.getCity());
		assertEquals(this.addressDTO.getCountry(), address.getCountry());
		assertEquals(this.addressDTO.getState(), address.getState());
		
		assertEquals(updateAddressDTO.getComplement(), address.getComplement());
		assertNotEquals(this.addressDTO.getComplement(), address.getComplement());
		
		assertEquals(updateAddressDTO.getNeighbourhood(), address.getNeighbourhood());
		assertNotEquals(this.addressDTO.getNeighbourhood(), address.getNeighbourhood());
		
		assertEquals(updateAddressDTO.getNumber(), address.getNumber());
		assertNotEquals(this.addressDTO.getNumber(), address.getNumber());
		
		assertEquals(updateAddressDTO.getStreetName(), address.getStreetName());
		assertNotEquals(this.addressDTO.getStreetName(), address.getStreetName());
		
		
		assertEquals(-22.9031949 , address.getLatitude());
		assertNotEquals(-22.9108864 , address.getLatitude());
		
		assertEquals(-47.0540072, address.getLongitude());
		assertNotEquals(-47.0433847, address.getLongitude());
		
		assertEquals(updateAddressDTO.getZipcode(), address.getZipcode());
		assertNotEquals(this.addressDTO.getZipcode(), address.getZipcode());
		
	}
	
	@Test
	public void testDelete() {
		
		final AddressDTO deleteAddressDTO = BuilderAddressDTO.create()
				.setId(CrudApplicationTests.id)
				.build();
		
		final boolean addressDeleted = this.addressService.executeDelete(deleteAddressDTO);
	
		assertTrue(addressDeleted);
	}
	
	
	@Test
	public void testReadAll() {
		
		this.addressService.executeCreate(this.addressDTO);
		
		final List<Address> listAddress = this.addressService.executeReadAll();
		
		final Address address = listAddress.get(0);
	
		assertEquals(this.addressDTO.getCity(), address.getCity());
		assertEquals(this.addressDTO.getComplement(), address.getComplement());
		assertEquals(this.addressDTO.getCountry(), address.getCountry());
		assertEquals(this.addressDTO.getNeighbourhood(), address.getNeighbourhood());
		assertEquals(this.addressDTO.getNumber(), address.getNumber());
		assertEquals(this.addressDTO.getState(), address.getState());
		assertEquals(this.addressDTO.getStreetName(), address.getStreetName());
		assertEquals(-22.9108864 , address.getLatitude());
		assertEquals(-47.0433847, address.getLongitude());
		assertEquals(this.addressDTO.getZipcode(), address.getZipcode());
	}

}
