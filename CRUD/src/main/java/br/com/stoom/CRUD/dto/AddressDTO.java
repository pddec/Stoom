package br.com.stoom.CRUD.dto;

public class AddressDTO {
	
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
    
	private AddressDTO() {}
    
    public Long getId() {
		return this.id;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public Integer getNumber() {
		return this.number;
	}

	public Integer getComplement() {
		return this.complement;
	}

	public String getNeighbourhood() {
		return this.neighbourhood;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public String getCountry() {
		return this.country;
	}

	public Long getZipcode() {
		return this.zipcode;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}
	

    private AddressDTO setId(Long id) {
		this.id = id;
		return this;
	}

	private AddressDTO setStreetName(String streetName) {
		this.streetName = streetName;
		return this;
	}

	private AddressDTO setNumber(Integer number) {
		this.number = number;
		return this;
	}

	private AddressDTO setComplement(Integer complement) {
		this.complement = complement;
		return this;
	}

	private AddressDTO setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
		return this;
	}

	private AddressDTO setCity(String city) {
		this.city = city;
		return this;
	}

	private AddressDTO setState(String state) {
		this.state = state;
		return this;
	}

	private AddressDTO setCountry(String country) {
		this.country = country;
		return this;
	}

	private AddressDTO setZipcode(Long zipcode) {
		this.zipcode = zipcode;
		return this;
	}

	private AddressDTO setLatitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	private AddressDTO setLongitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	private static AddressDTO create() {
    	return new AddressDTO();
    }

    @Override
    public String toString() {
    	return new StringBuilder(this.getStreetName())
    			.append(", ")
				.append(this.getCity())
				.append(" - ")
				.append(this.getState())
				.append(", ")
				.append(this.getZipcode())
				.append(", ")
				.append(this.getCountry())
				.toString();
    }
    
    
	public static class BuilderAddressDTO {
		
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
		
		private BuilderAddressDTO() {}
		
		public BuilderAddressDTO setId(Long id) {
			this.id = id;
			return this;
		}
		
		public BuilderAddressDTO setId(String id) {
			if(id == "") return this;
			this.id = Long.parseLong(id);
			return this;
		}

		public BuilderAddressDTO setStreetName(String streetName) {
			this.streetName = streetName;
			return this;
		}

		public BuilderAddressDTO setNumber(String number) {
			if(number == "") return this;
			this.number = Integer.parseInt(number);
			return this;
		}
		
		public BuilderAddressDTO setNumber(Integer number) {
			this.number = number;
			return this;
		}

		public BuilderAddressDTO setComplement(String complement) {
			if(complement == "") return this;
			this.complement = Integer.parseInt(complement);
			return this;
		}
		
		public BuilderAddressDTO setComplement(Integer complement) {
			this.complement = complement;
			return this;
		}

		public BuilderAddressDTO setNeighbourhood(String neighbourhood) {
			this.neighbourhood = neighbourhood;
			return this;
		}

		public BuilderAddressDTO setCity(String city) {
			this.city = city;
			return this;
		}

		public BuilderAddressDTO setState(String state) {
			this.state = state;
			return this;
		}

		public BuilderAddressDTO setCountry(String country) {
			this.country = country;
			return this;
		}

		public BuilderAddressDTO setZipcode(String zipcode) {
			if(zipcode == "") return this;
			this.zipcode = Long.parseLong(zipcode);
			return this;
		}

		public BuilderAddressDTO setLatitude(String latitude) {
			if(latitude == "") return this;
			this.latitude = Double.parseDouble(latitude);
			return this;
		}

		public BuilderAddressDTO setLongitude(String longitude) {
			if(longitude == "") return this;
			this.longitude = Double.parseDouble(longitude);
			return this;
		}
		
		public BuilderAddressDTO setZipcode(Long zipcode) {
			this.zipcode = zipcode;
			return this;
		}

		public BuilderAddressDTO setLatitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}

		public BuilderAddressDTO setLongitude(Double longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public AddressDTO build() {
			return AddressDTO.create()
					.setId(this.id)
					.setCity(this.city)
					.setComplement(this.complement)
					.setCountry(this.country)
					.setNeighbourhood(this.neighbourhood)
					.setNumber(this.number)
					.setStreetName(this.streetName)
					.setState(this.state)
					.setZipcode(this.zipcode)
					.setLatitude(this.latitude)
					.setLongitude(this.longitude);
		}
		
		public static BuilderAddressDTO create() {
			return new BuilderAddressDTO();
		}
		
	}

}
