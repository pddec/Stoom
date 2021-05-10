package br.com.stoom.CRUD.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.stoom.CRUD.dto.AddressDTO;

@Entity
public class Address {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetName;
    private Integer number;
    private Integer complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private Long zipcode;
    private	Double latitude;
    private Double longitude;
    
    
    public Address() {}

	public Address(AddressDTO addressDTO) {
		this.id = addressDTO.getId();
		this.streetName = addressDTO.getStreetName();
		this.number = addressDTO.getNumber();
		this.complement = addressDTO.getComplement();
		this.neighbourhood = addressDTO.getNeighbourhood();		
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.country = addressDTO.getCountry();
		this.zipcode = addressDTO.getZipcode();
		this.latitude = addressDTO.getLatitude();
		this.longitude = addressDTO.getLongitude();
	}
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreetName() {
		return this.streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Integer getNumber() {
		return this.number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getComplement() {
		return this.complement;
	}
	public void setComplement(Integer complement) {
		this.complement = complement;
	}
	public String getNeighbourhood() {
		return this.neighbourhood;
	}
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getZipcode() {
		return this.zipcode;
	}
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}
	public Double getLatitude() {
		return this.latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return this.longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public boolean equals(Object obj) {
		final Address address = (Address) obj;
		return this.id == address.id;
	}

	@Override
	public String toString() {
		return new StringBuilder("Id: ")
				.append(this.id)
				.append(" - Street Name: ")
				.append(this.streetName)
				.append(" - Number: ")
				.append(this.number)
				.append(" - Complement: ")
				.append(this.complement)
				.append(" - Neighbourhood: ")
				.append(this.neighbourhood)
				.append(" - City: ")
				.append(this.city)
				.append(" - State: ")
				.append(this.state)
				.append(" - Country: ")
				.append(this.country)
				.append(" - Zipcode: ")
				.append(this.zipcode)
				.append(" - Latitude: ")
				.append(this.latitude)
				.append(" - Longitude: ")
				.append(this.longitude)
				.toString();
	}

    
    
}
